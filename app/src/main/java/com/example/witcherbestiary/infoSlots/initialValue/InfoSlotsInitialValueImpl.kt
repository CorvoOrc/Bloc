package com.example.witcherbestiary.infoSlots.initialValue

import com.example.witcherbestiary.infoSlot.initialValue.InfoSlotInitialValue
import com.example.witcherbestiary.model.Creature
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoSlotsInitialValueImpl(
        override var item: Creature? = null,
        override val index: Int = 0,
        override val list: List<InfoSlotInitialValue> = listOf()
) : InfoSlotsInitialValue