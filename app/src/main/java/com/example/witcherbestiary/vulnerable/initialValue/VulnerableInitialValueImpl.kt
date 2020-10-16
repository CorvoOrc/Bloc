package com.example.witcherbestiary.vulnerable.initialValue

import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.model.Vulnerable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VulnerableInitialValueImpl(
        override val item: Creature,
        override val vulnerables: List<Vulnerable> = listOf()
) : VulnerableInitialValue