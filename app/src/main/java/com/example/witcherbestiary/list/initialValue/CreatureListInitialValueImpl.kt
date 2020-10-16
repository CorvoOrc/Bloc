package com.example.witcherbestiary.list.initialValue

import com.example.witcherbestiary.card.initialValue.CardInitialValue
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CreatureListInitialValueImpl(
        override val items: List<CardInitialValue>
) : CreatureListInitialValue