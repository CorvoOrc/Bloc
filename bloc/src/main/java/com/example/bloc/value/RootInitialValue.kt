package com.example.bloc.value

import android.os.Parcelable

interface RootInitialValue : InitialValue {
    val router: Parcelable
}