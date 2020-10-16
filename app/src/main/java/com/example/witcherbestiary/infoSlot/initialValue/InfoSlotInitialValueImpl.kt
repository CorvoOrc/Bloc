package com.example.witcherbestiary.infoSlot.initialValue

import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.model.Creature
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoSlotInitialValueImpl(
        override var item: Creature? = null,
        override val child: InitialValue? = null
) : InfoSlotInitialValue