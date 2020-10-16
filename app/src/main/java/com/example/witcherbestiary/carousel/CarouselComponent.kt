package com.example.witcherbestiary.carousel

import com.example.witcherbestiary.carousel.description.CarouselDescription
import com.example.witcherbestiary.carousel.view.CarouselView
import com.example.witcherbestiary.carousel.view.description.CarouselViewDescription
import com.example.witcherbestiary.carouselSlot.CarouselSlotComponent
import com.example.witcherbestiary.carouselSlot.description.CarouselSlotDescription
import com.example.witcherbestiary.carouselSlot.view.CarouselSlotView
import com.example.witcherbestiary.carouselSlot.view.description.CarouselSlotViewDescription
import com.example.bloc.component.CollectionComponent
import com.example.witcherbestiary.model.Creature

interface CarouselComponent : CollectionComponent<CarouselSlotViewDescription, CarouselSlotDescription, CarouselSlotView, CarouselSlotComponent, CarouselViewDescription, CarouselDescription, CarouselView> {
    interface ViewEvents {
        fun prepareCreatingItems()
        fun createItem(item: Creature): CarouselSlotView
        fun changePage(prev: Int, new: Int, currentItem: Creature)
    }

    sealed class Input {
        data class SetSelection(val item: Creature?) : Input()
    }
    sealed class Output {
        data class Changed(val prev: Int, val current: Int, val item: Creature) : Output()
        data class Updated(val item: Creature?) : Output()
    }
}