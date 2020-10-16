package com.example.witcherbestiary.carouselSlot

import com.example.witcherbestiary.carouselSlot.description.CarouselSlotDescription
import com.example.witcherbestiary.carouselSlot.view.CarouselSlotView
import com.example.witcherbestiary.carouselSlot.view.description.CarouselSlotViewDescription
import com.example.bloc.component.Component
import com.example.witcherbestiary.model.Creature

interface CarouselSlotComponent : Component<CarouselSlotViewDescription, CarouselSlotDescription, CarouselSlotView> {
    sealed class Input {
        data class SetItem(val item: Creature) : Input()
    }
    sealed class Output
}