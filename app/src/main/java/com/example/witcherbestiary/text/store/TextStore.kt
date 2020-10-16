package com.example.witcherbestiary.text.store

import com.example.bloc.store.Store

interface TextStore : Store<TextStore.Intent, TextStore.State> {
    sealed class Intent {
        data class Set(val text: String) : Intent()
    }

    data class State(val text: String)
}