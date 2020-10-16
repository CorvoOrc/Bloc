package com.example.bloc.description

interface ComponentDescription<TView : ViewDescription> : Description {
    val view: TView
}