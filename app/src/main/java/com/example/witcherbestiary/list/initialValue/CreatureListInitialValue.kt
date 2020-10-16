package com.example.witcherbestiary.list.initialValue

import com.example.witcherbestiary.card.initialValue.CardInitialValue
import com.example.bloc.value.InitialValue

interface CreatureListInitialValue : InitialValue {
    val items: List<CardInitialValue>
}