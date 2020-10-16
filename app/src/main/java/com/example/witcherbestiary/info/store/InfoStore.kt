package com.example.witcherbestiary.info.store

import com.example.bloc.store.Store
import com.example.witcherbestiary.model.Creature

interface InfoStore: Store<InfoStore.Intent, InfoStore.State> {
    sealed class Intent {
        data class Set(val item: Creature) : Intent()
    }

    data class State(val item: Creature)
}