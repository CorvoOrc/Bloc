package com.example.bloc.component

import com.example.bloc.description.ComponentDescription
import com.example.bloc.description.ViewDescription
import com.example.bloc.router.Router
import com.example.bloc.view.View

interface RootComponent<TViewDescription : ViewDescription, TDescription: ComponentDescription<TViewDescription>, TView : View<TViewDescription>>
    : Component<TViewDescription, TDescription, TView> {
    val router: Router
}