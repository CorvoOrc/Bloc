package com.example.bloc.router

import com.example.bloc.value.InitialValue
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RouterInitialValue(
        var stack: List<String>
) : InitialValue