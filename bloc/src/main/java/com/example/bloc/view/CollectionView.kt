package com.example.bloc.view

import com.example.bloc.description.ViewDescription

interface CollectionView<TDescription: ViewDescription, TChildDescription: ViewDescription, TChildView : View<TChildDescription>> :
    View<TDescription> {
    val items: List<TChildView>
}