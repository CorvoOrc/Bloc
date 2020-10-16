package com.example.bloc.description

interface RootDescription<TViewDescription : ViewDescription> :
    ComponentDescription<TViewDescription> {
    val initialComponent: String
}