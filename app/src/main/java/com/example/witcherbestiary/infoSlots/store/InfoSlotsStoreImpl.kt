package com.example.witcherbestiary.infoSlots.store

import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.infoSlots.initialValue.InfoSlotsInitialValue
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.example.witcherbestiary.infoSlots.store.InfoSlotsStore.Intent as Intent
import com.example.witcherbestiary.infoSlots.store.InfoSlotsStore.State as State

internal class InfoSlotsStoreImpl @Inject constructor(
    initialValue: InfoSlotsInitialValue
) : StoreBase<Intent, State>(State(initialValue.index)), InfoSlotsStore {
    override fun init() {
        init(Reducer(state))
    }

    private class Reducer(val state: StateFlow<State>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when(intent) {
                is Intent.Set -> set(intent.index)
            }
        }

        private fun set(index: Int): State = state.value.copy(index = index)
    }
}