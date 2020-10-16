package com.example.witcherbestiary.main.store

import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.main.initialValue.MainInitialValue
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.example.witcherbestiary.main.store.BestiaryMainStore.Intent as Intent
import com.example.witcherbestiary.main.store.BestiaryMainStore.State as State

internal class BestiaryMainStoreImpl @Inject constructor(
    initialValue: MainInitialValue
) : StoreBase<Intent, State>(State(initialValue.scroll)), BestiaryMainStore {
    override fun init() {
        init(Reducer(state))
    }

    private class Reducer(val state: StateFlow<State>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when(intent) {
                is Intent.SetScroll -> setScroll(intent.scrollPos)
            }
        }

        private fun setScroll(scrollPos: Float): State = state.value.copy(scrollPos = scrollPos)
    }
}