package com.example.bloc.view

import com.example.bloc.description.ViewDescription
import kotlinx.coroutines.flow.StateFlow

abstract class ViewBase<TDescription : ViewDescription, TState : Any, TEvent : Any> : View<TDescription> {
    override lateinit var description: TDescription
    protected lateinit var state: StateFlow<TState>
    protected var events: TEvent? = null

    override fun init(description: TDescription, state: StateFlow<*>, events: Any?) {
        this.description = description
        this.state = state as StateFlow<TState>
        this.events = events as TEvent?
    }

    override fun destroy() {
        events = null
    }
}