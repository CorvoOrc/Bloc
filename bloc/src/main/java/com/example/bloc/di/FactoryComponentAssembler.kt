package com.example.bloc.di

import com.example.bloc.component.Component
import com.example.bloc.description.TypedComponentDescription

interface FactoryComponentAssembler<TDescription: TypedComponentDescription<*>, TComponent : Component<*, *, *>, TFactory: Factory<TComponent>> :
    ComponentAssembler<TDescription, TComponent> {
    val factory: TFactory

    override fun createComponent(): TComponent = factory.build(description.type)
}