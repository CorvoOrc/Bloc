package com.example.witcherbestiary.vulnerable.store

import com.example.bloc.store.Store
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.model.Vulnerable

interface CreatureVulnerablesStore :
    Store<CreatureVulnerablesStore.Intent, CreatureVulnerablesStore.State> {
    sealed class Intent {
        data class SetItem(val item: Creature) : Intent()
        data class Update(val items: List<Vulnerable>) : Intent()
    }

    data class State(val item: Creature, val vulnerables: List<Vulnerable>)
}