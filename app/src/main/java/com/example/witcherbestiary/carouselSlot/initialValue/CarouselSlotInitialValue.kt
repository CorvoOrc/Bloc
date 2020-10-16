package com.example.witcherbestiary.carouselSlot.initialValue

import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.model.Creature

interface CarouselSlotInitialValue : InitialValue {
    val item: Creature
}