package com.example.witcherbestiary.carouselSlot.store

import com.example.bloc.store.Store
import com.example.witcherbestiary.model.Creature

interface CarouselSlotStore: Store<CarouselSlotStore.Intent, CarouselSlotStore.State> {
    sealed class Intent {
        data class SetItem(val item: Creature) : Intent()
    }

    data class State(val item: Creature)
}