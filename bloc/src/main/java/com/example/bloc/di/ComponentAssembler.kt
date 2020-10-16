package com.example.bloc.di

import com.example.bloc.component.Component
import com.example.bloc.description.ComponentDescription

interface ComponentAssembler<TDesription: ComponentDescription<*>, TComponent : Component<*, *, *>> {
    val description: TDesription

    fun createComponent(): TComponent
}