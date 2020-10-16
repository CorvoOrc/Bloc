package com.example.witcherbestiary.card.initialValue

import com.example.witcherbestiary.model.Creature
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardInitialValueImpl(
        override val item: Creature
) : CardInitialValue