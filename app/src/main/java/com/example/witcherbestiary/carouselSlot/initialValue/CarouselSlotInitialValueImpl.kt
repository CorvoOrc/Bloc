package com.example.witcherbestiary.carouselSlot.initialValue

import com.example.witcherbestiary.model.Creature
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CarouselSlotInitialValueImpl(
        override val item: Creature
) : CarouselSlotInitialValue