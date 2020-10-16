package com.example.witcherbestiary.tab.store

import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.tab.description.TabRowDescription
import com.example.witcherbestiary.tab.initialValue.TabRowInitialValue
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.example.witcherbestiary.tab.store.TabRowStore.Intent as Intent
import com.example.witcherbestiary.tab.store.TabRowStore.State as State

internal class TabRowStoreImpl @Inject constructor(
    description: TabRowDescription,
    initialValue: TabRowInitialValue
) : StoreBase<Intent, State>(
    State(
        if (initialValue.tabList.isNotEmpty()) initialValue.tabList else description.tabs,
        if (initialValue.index != -1) initialValue.index else description.startIndex
    )
), TabRowStore {
    override fun init() {
        init(Reducer(state))
    }

    private class Reducer(val state: StateFlow<State>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when (intent) {
                is Intent.Set -> set(intent.index)
            }
        }

        private fun set(index: Int): State = state.value.copy(index = index)
    }
}