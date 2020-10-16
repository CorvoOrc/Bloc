package com.example.witcherbestiary.carousel.initialValue

import com.example.witcherbestiary.carouselSlot.initialValue.CarouselSlotInitialValue
import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.model.Creature

interface CarouselInitialValue : InitialValue {
    val selection: Creature
    val list: List<CarouselSlotInitialValue>
    val prev: Int
    val current: Int
}