package com.example.witcherbestiary.location.initialValue

import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.model.Location

interface LocationInitialValue : InitialValue {
    val item: Creature
    val locations: List<Location>
}