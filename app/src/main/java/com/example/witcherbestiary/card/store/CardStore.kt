package com.example.witcherbestiary.card.store

import com.example.bloc.store.Store
import com.example.witcherbestiary.model.Creature

interface CardStore : Store<CardStore.Intent, CardStore.State> {
    sealed class Intent {
        data class SetItem(val item: Creature) : Intent()
        data class UpdateItem(val item: Creature) : Intent()
    }

    data class State(val item: Creature)
}