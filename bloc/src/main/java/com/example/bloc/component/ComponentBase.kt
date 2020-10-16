package com.example.bloc.component

import com.example.bloc.description.ComponentDescription
import com.example.bloc.description.ViewDescription
import com.example.bloc.store.Store
import com.example.bloc.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

abstract class ComponentBase<TViewDescription : ViewDescription, TDescription: ComponentDescription<TViewDescription>, TView : View<TViewDescription>, TStore: Store<*, *>>(
        override val description: TDescription,
        protected val store: TStore,
        override val view: TView
) : Component<TViewDescription, TDescription, TView> {
    private val childs: MutableList<Component<*, *, *>> = mutableListOf()

    protected val scope: CoroutineScope = CoroutineScope(Dispatchers.Default)

    override fun init() {
        store.init()
        view.init(description.view, store.state, this)
    }

    protected fun addChild(component: Component<*, *, *>) {
        childs.add(component)
        component.init()
    }
    protected fun removeChild(component: Component<*, *, *>) {
        component.destroy()
        childs.remove(component)
    }

    private fun destroyChilds() {
        childs.forEach { it.destroy() }
        childs.clear()
    }

    override fun destroy() {
        destroyChilds()

        view.destroy()
        store.destroy()
        scope.cancel()
    }
}