package com.example.witcherbestiary.list.store

import com.example.bloc.store.Store
import com.example.witcherbestiary.model.Creature

interface CreatureListStore : Store<CreatureListStore.Intent, CreatureListStore.State> {
    sealed class Intent {
        data class Update(val items: List<Creature>) : Intent()
    }

    data class State(val items: List<Creature>)
}