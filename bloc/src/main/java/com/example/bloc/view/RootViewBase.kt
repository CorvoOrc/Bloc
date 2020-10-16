package com.example.bloc.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.bloc.description.ViewDescription
import com.example.bloc.router.Router
import kotlinx.coroutines.flow.StateFlow

abstract class RootViewBase<TDescription : ViewDescription, TState : Any, TEvent : RootViewEvents> :
        ViewBase<TDescription, TState, TEvent>() {
    private lateinit var routerState: StateFlow<Router.State>

    override fun init(description: TDescription, state: StateFlow<*>, events: Any?) {
        super.init(description, state, events)

        routerState = this.events!!.router.state
    }

    @Composable
    protected abstract fun renderOut()

    @Composable
    private fun renderRouter() {
        val routerState = routerState.collectAsState()
        if (routerState.value.top != null)
            routerState.value.top!!.view.render()
    }

    @Composable
    override fun render() {
        renderOut()
        renderRouter()
    }
}