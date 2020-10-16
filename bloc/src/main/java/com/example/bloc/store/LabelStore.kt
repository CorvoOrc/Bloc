package com.example.bloc.store

import kotlinx.coroutines.channels.ReceiveChannel

interface LabelStore<in TIntent: Any, out TState: Any, TLabel: Any> : Store<TIntent, TState> {
    val labelChannel: ReceiveChannel<TLabel>

    fun mark(label: TLabel)
}