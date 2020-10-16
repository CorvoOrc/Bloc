package com.example.witcherbestiary.tab.store

import com.example.bloc.store.Store

interface TabRowStore : Store<TabRowStore.Intent, TabRowStore.State> {
    sealed class Intent {
        data class Set(val index: Int): Intent()
    }

    data class State(val tabs: List<String>, val index: Int)
}