package com.example.witcherbestiary.main.initialValue

import com.example.witcherbestiary.header.initialValue.HeaderInitialValue
import com.example.witcherbestiary.list.initialValue.CreatureListInitialValue
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainInitialValueImpl(
        override val scroll: Float = 0f,
        override val header: HeaderInitialValue? = null,
        override val list: CreatureListInitialValue? = null
) : MainInitialValue