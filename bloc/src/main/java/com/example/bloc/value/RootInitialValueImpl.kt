package com.example.bloc.value

import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RootInitialValueImpl(
        override val router: Parcelable = Bundle()
) : RootInitialValue