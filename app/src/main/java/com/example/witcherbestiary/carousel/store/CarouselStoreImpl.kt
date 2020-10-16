package com.example.witcherbestiary.carousel.store

import com.example.witcherbestiary.carousel.initialValue.CarouselInitialValue
import com.example.bloc.store.LabelStoreBase
import com.example.bloc.store.Store
import com.example.witcherbestiary.data.CreatureRepository
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.carousel.store.CarouselStore.Intent as Intent
import com.example.witcherbestiary.carousel.store.CarouselStore.State as State
import com.example.witcherbestiary.carousel.store.CarouselStore.Label as Label

internal class CarouselStoreImpl @Inject constructor(
    initialValue: CarouselInitialValue,
    val repository: CreatureRepository
) :  LabelStoreBase<Intent, State, Label>(State(initialValue.list.map{ it.item }, initialValue.prev, initialValue.current, initialValue.selection)),
    CarouselStore
{
    private val selection = MutableStateFlow<Creature?>(initialValue.selection)
    private var job: Job = Job()

    override fun init() {
        init(Reducer(state, selection))

        scope.launch {
            combine(repository.getList(), selection) { list, selection ->
                combineState(list, selection)
            }.collect {
                execute(Intent.Update(it.items, it.prev, it.current, it.selection))
            }
        }

        scope.launch {
            selection.collect {
                if (job.isActive)
                    job.cancel()

                job = launch {
                    try {
                        if (it != null)
                            repository.getById(it.id).collect {
                                selection.value = it
                                mark(Label.Updated(it))
                            }
                    }
                    finally { }
                }
            }
        }
    }

    private fun combineState(items: List<Creature>, item: Creature?): State {
        var prev = state.value.current
        val current = if (item == null || items.isEmpty()) -1 else items.indexOfFirst { it.id == item.id }
        prev = if (prev != current) prev else state.value.prev
        return State(items = items, prev = prev, current = current, selection = item)
    }

    private class Reducer(val state: StateFlow<State>, val selection: MutableStateFlow<Creature?>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when (intent) {
                is Intent.SetSelection -> setSelection(intent.item)
                is Intent.Update -> update(intent.items, intent.prev, intent.current, intent.selection)
            }
        }

        private fun setSelection(item: Creature?): State {
            selection.value = item
            return state.value
        }

        private fun update(items: List<Creature>, prev: Int, current: Int, selection: Creature?): State =
                state.value.copy(items = items, prev = prev, current = current, selection = selection)
    }
}