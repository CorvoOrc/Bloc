package com.example.witcherbestiary.infoSlot.initialValue

import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.model.Creature

interface InfoSlotInitialValue : InitialValue {
    var item: Creature?
    val child: InitialValue?
}