package com.example.witcherbestiary.carousel.store

import com.example.bloc.store.LabelStore
import com.example.witcherbestiary.model.Creature

interface CarouselStore : LabelStore<CarouselStore.Intent, CarouselStore.State, CarouselStore.Label> { //Store<CarouselStore.Intent, CarouselStore.State> {
    sealed class Intent {
        data class SetSelection(val item: Creature?) : Intent()
        data class Update(val items: List<Creature>, val prev: Int, val current: Int, val selection: Creature?) : Intent()
    }

    data class State(val items: List<Creature>, val prev: Int, val current: Int, val selection: Creature?)

    sealed class Label {
        data class Updated(val item: Creature?) : Label()
    }
}