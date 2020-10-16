package com.example.witcherbestiary.info.initialValue

import com.example.witcherbestiary.infoSlots.initialValue.InfoSlotsInitialValue
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.tab.initialValue.TabRowInitialValue
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoInitialValueImpl(
        override val item: Creature,
        override val infoSlots: InfoSlotsInitialValue? = null,
        override val tabRow: TabRowInitialValue? = null
) : InfoInitialValue