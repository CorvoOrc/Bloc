package com.example.bloc.description

interface DescriptionGraph<TDescription : RootDescription<*>> : Description {
    val rootComponent: TDescription
    val database: String
}