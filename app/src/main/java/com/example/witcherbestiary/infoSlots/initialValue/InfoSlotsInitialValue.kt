package com.example.witcherbestiary.infoSlots.initialValue

import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.infoSlot.initialValue.InfoSlotInitialValue
import com.example.witcherbestiary.model.Creature

interface InfoSlotsInitialValue : InitialValue {
    var item: Creature?
    val index: Int
    val list: List<InfoSlotInitialValue>
}