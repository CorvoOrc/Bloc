package com.example.bloc.store

import com.example.bloc.common.Initializable
import com.example.bloc.common.Destroyable
import kotlinx.coroutines.flow.StateFlow

interface Store<in TIntent: Any, out TState: Any> : Initializable, Destroyable {
    val state: StateFlow<TState>

    fun execute(intent: TIntent)

    interface Reducer<in TIntent, out TState> {
        fun reduce(intent: TIntent): TState
    }
}