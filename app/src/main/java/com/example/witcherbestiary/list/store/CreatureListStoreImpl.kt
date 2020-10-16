package com.example.witcherbestiary.list.store

import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.data.CreatureRepository
import com.example.witcherbestiary.list.initialValue.CreatureListInitialValue
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.list.store.CreatureListStore.Intent as Intent
import com.example.witcherbestiary.list.store.CreatureListStore.State as State

internal class CreatureListStoreImpl @Inject constructor(
    initialValue: CreatureListInitialValue,
    val repository: CreatureRepository
) : StoreBase<Intent, State>(State(initialValue.items.map { it.item })), CreatureListStore {
    override fun init() {
        init(Reducer(state))

        scope.launch {
            repository.getList().collect {
                execute(Intent.Update(it))
            }
        }
    }

    private class Reducer(val state: StateFlow<State>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when (intent) {
                is Intent.Update -> update(intent.items)
            }
        }

        private fun update(items: List<Creature>): State = state.value.copy(items = items)
    }
}