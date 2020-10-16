package com.example.witcherbestiary.info.initialValue

import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.infoSlots.initialValue.InfoSlotsInitialValue
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.tab.initialValue.TabRowInitialValue

interface InfoInitialValue : InitialValue {
    val item: Creature
    val infoSlots: InfoSlotsInitialValue?
    val tabRow: TabRowInitialValue?
}