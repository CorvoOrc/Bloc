package com.example.bloc.router

import android.os.Parcelable
import com.example.bloc.component.Component
import com.example.bloc.value.InitialValue
import kotlinx.coroutines.flow.StateFlow
import java.util.*

interface Router {
    val state: StateFlow<State>

    fun init(routeCallback: (String, Parcelable?) -> Component<*, *, *>, parcel: Parcelable, initial: String)

    fun push(id: String, initialValue: InitialValue?)
    fun pop(): Component<*, *, *>

    fun getParcel(): Parcelable

    data class State(val stack: Stack<Component<*, *, *>>, val top: Component<*, *, *>?)
}