package com.example.witcherbestiary.main.initialValue

import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.header.initialValue.HeaderInitialValue
import com.example.witcherbestiary.list.initialValue.CreatureListInitialValue

interface MainInitialValue : InitialValue {
    val scroll: Float
    val header: HeaderInitialValue?
    val list: CreatureListInitialValue?
}