package com.example.bloc.view

import com.example.bloc.description.ViewDescription

abstract class CollectionViewBase<TDescription: ViewDescription, TChildDescription: ViewDescription, TChildView : View<TChildDescription>, TStore : Any, TEvent : Any> :
        ViewBase<TDescription, TStore, TEvent>(),
    CollectionView<TDescription, TChildDescription, TChildView> {
    private val mutableItems = mutableListOf<TChildView>()
    override val items: List<TChildView> = mutableItems

    protected fun add(view: TChildView): Boolean = mutableItems.add(view)

    protected fun remove(view: TChildView): Boolean = mutableItems.remove(view)

    protected fun addAll(collection: List<TChildView>): Boolean = mutableItems.addAll(collection)

    protected fun clear() {
        mutableItems.clear()
    }
}