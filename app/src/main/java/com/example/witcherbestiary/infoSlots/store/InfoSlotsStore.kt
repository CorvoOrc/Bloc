package com.example.witcherbestiary.infoSlots.store

import com.example.bloc.store.Store

interface InfoSlotsStore: Store<InfoSlotsStore.Intent, InfoSlotsStore.State> {
    sealed class Intent {
        data class Set(val index: Int) : Intent()
    }

    data class State(val index: Int)
}