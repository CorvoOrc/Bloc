package com.example.witcherbestiary.location.store

import com.example.bloc.store.Store
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.model.Location

interface CreatureLocationStore :
    Store<CreatureLocationStore.Intent, CreatureLocationStore.State> {
    sealed class Intent {
        data class SetItem(val item: Creature) : Intent()
        data class Update(val items: List<Location>) : Intent()
    }

    data class State(val item: Creature, val locations: List<Location>)
}