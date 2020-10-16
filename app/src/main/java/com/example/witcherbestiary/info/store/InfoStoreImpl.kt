package com.example.witcherbestiary.info.store

import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.data.CreatureRepository
import com.example.witcherbestiary.info.initialValue.InfoInitialValue
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.example.witcherbestiary.info.store.InfoStore.Intent as Intent
import com.example.witcherbestiary.info.store.InfoStore.State as State


internal class InfoStoreImpl @Inject constructor(
    initialValue: InfoInitialValue,
    val repository: CreatureRepository
): StoreBase<Intent, State>(State(initialValue.item)), InfoStore {
    override fun init() {
        init(Reducer(state))
    }

    private class Reducer(val state: StateFlow<State>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when(intent) {
                is Intent.Set -> set(intent.item)
            }
        }

        private fun set(item: Creature): State {
            return state.value.copy(item = item)
        }
    }
}