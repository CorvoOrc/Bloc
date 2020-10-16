package com.example.witcherbestiary.header.store

import com.example.bloc.store.Store

interface HeaderStore : Store<HeaderStore.Intent, HeaderStore.State> {
    sealed class Intent {
        data class SetText(val text: String) : Intent()
    }

    data class State(val text: String)
}