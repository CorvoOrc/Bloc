package com.example.witcherbestiary.header.initialValue

import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeaderInitialValueImpl(
        override val text: String? = null
) : HeaderInitialValue