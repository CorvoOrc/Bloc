package com.example.witcherbestiary.location.initialValue

import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.model.Location
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationInitialValueImpl(
        override val item: Creature,
        override val locations: List<Location> = listOf()
) : LocationInitialValue