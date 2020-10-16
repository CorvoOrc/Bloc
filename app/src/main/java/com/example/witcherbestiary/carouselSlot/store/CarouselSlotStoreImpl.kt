package com.example.witcherbestiary.carouselSlot.store

import com.example.witcherbestiary.carouselSlot.initialValue.CarouselSlotInitialValue
import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.data.CreatureRepository
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject
import com.example.witcherbestiary.carouselSlot.store.CarouselSlotStore.Intent as Intent
import com.example.witcherbestiary.carouselSlot.store.CarouselSlotStore.State as State

internal class CarouselSlotStoreImpl @Inject constructor(
    val initialValue: CarouselSlotInitialValue,
    val repository: CreatureRepository
) : StoreBase<Intent, State>(State(initialValue.item)), CarouselSlotStore {
    override fun init() {
        init(Reducer(state))

        scope.launch {
            repository.getById(initialValue.item.id).collect {
                if (it != null)
                    execute(Intent.SetItem(it))
            }
        }
    }

    private class Reducer(val state: StateFlow<State>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when(intent) {
                is Intent.SetItem -> setItem(intent.item)
            }
        }

        private fun setItem(item: Creature) = state.value.copy(item = item)
    }
}