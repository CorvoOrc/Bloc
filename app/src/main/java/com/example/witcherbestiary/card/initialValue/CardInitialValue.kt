package com.example.witcherbestiary.card.initialValue

import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.model.Creature

interface CardInitialValue : InitialValue {
    val item: Creature
}