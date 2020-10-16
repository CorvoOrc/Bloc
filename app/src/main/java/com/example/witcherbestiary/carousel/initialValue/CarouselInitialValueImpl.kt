package com.example.witcherbestiary.carousel.initialValue

import com.example.witcherbestiary.carouselSlot.initialValue.CarouselSlotInitialValue
import com.example.witcherbestiary.model.Creature
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CarouselInitialValueImpl(
        override val selection: Creature,
        override val list: List<CarouselSlotInitialValue> = listOf(),
        override val prev: Int = -1,
        override val current: Int = 0
) : CarouselInitialValue