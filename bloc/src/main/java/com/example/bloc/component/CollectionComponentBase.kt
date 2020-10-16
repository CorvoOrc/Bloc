package com.example.bloc.component

import com.example.bloc.description.ComponentDescription
import com.example.bloc.description.ViewDescription
import com.example.bloc.store.Store
import com.example.bloc.view.CollectionView
import com.example.bloc.view.View

abstract class CollectionComponentBase<TChildViewDescription : ViewDescription,
        TChildDescription : ComponentDescription<TChildViewDescription>,
        TChildView : View<TChildViewDescription>,
        TChildComponent : Component<TChildViewDescription, TChildDescription, TChildView>,
        TViewDescription : ViewDescription,
        TDescription : ComponentDescription<TViewDescription>,
        TView : CollectionView<TViewDescription, TChildViewDescription, TChildView>,
        TStore : Store<*, *>>
(
        description: TDescription,
        store: TStore,
        view: TView
) : ComponentBase<TViewDescription, TDescription, TView, TStore>(description, store, view),
    CollectionComponent<TChildViewDescription, TChildDescription, TChildView, TChildComponent, TViewDescription, TDescription, TView> {
    private val mutableItems = mutableListOf<TChildComponent>()
    override val items: List<TChildComponent> = mutableItems

    protected fun add(component: TChildComponent): Boolean = mutableItems.add(component)
    protected fun remove(component: TChildComponent): Boolean = mutableItems.remove(component)

    protected fun clear() {
        mutableItems.forEach { it.destroy() }
        mutableItems.clear()
    }

    override fun destroy() {
        clear()

        super.destroy()
    }
}