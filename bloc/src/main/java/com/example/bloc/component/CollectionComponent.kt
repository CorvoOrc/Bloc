package com.example.bloc.component

import com.example.bloc.description.ComponentDescription
import com.example.bloc.description.ViewDescription
import com.example.bloc.view.CollectionView
import com.example.bloc.view.View

interface CollectionComponent<TChildViewDescription: ViewDescription,
        TChildDescription: ComponentDescription<TChildViewDescription>,
        TChildView: View<TChildViewDescription>,
        TChildComponent: Component<TChildViewDescription, TChildDescription, TChildView>,
        TViewDescription: ViewDescription,
        TDescription: ComponentDescription<TViewDescription>,
        TView: CollectionView<TViewDescription, TChildViewDescription, TChildView>> :
    Component<TViewDescription, TDescription, TView> {
    val items: List<TChildComponent>
}