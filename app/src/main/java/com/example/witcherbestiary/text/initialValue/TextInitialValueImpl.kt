package com.example.witcherbestiary.text.initialValue

import kotlinx.android.parcel.Parcelize

@Parcelize
data class TextInitialValueImpl(
        override val text: String = ""
) : TextInitialValue