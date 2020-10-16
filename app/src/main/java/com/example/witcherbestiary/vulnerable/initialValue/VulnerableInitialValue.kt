package com.example.witcherbestiary.vulnerable.initialValue

import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.model.Vulnerable

interface VulnerableInitialValue : InitialValue {
    val item: Creature
    val vulnerables: List<Vulnerable>
}