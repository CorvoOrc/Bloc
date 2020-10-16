package com.example.bloc.di

import com.example.bloc.description.DescriptionGraph
import javax.inject.Singleton

interface AppAssembler<TDescriptionGraph : DescriptionGraph<*>, TRootFactory : Any> {
    @Singleton
    val descriptionGraph: TDescriptionGraph

    fun rootFactory(): TRootFactory
}