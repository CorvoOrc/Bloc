package com.example.bloc.store

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.channels.actor

abstract class StoreBase<TIntent : Any, TState : Any>(
    initialValue: TState
) : Store<TIntent, TState> {
    private lateinit var channel: SendChannel<TIntent>

    private val _state = MutableStateFlow(initialValue)
    override val state: StateFlow<TState> = _state

    protected val scope: CoroutineScope = CoroutineScope(Dispatchers.Default)

    protected open fun init(reducer: Store.Reducer<TIntent, TState>) {
        channel = scope.actor {
            for(intent in channel)
                _state.value = reducer.reduce((intent))
        }
    }

    override fun execute(intent: TIntent) {
        scope.launch {
            try {
                channel.send(intent)
            }
            catch(e: Exception){
                println("Channel was closed")
            }
        }
    }

    override fun destroy() {
        channel.close()
        scope.cancel()
    }
}