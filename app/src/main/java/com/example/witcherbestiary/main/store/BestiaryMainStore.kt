package com.example.witcherbestiary.main.store

import com.example.bloc.store.Store

interface BestiaryMainStore : Store<BestiaryMainStore.Intent, BestiaryMainStore.State> {
    sealed class Intent {
        data class SetScroll(val scrollPos: Float) : Intent()
    }

    data class State(val scrollPos: Float)
}