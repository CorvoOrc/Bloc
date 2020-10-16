package com.example.witcherbestiary.tab.initialValue

import kotlinx.android.parcel.Parcelize

@Parcelize
data class TabRowInitialValueImpl(
        override val tabList: List<String> = listOf(),
        override val index: Int = -1
) : TabRowInitialValue