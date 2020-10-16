package com.example.witcherbestiary.root

import com.example.bloc.component.RootComponent
import com.example.witcherbestiary.root.description.BestiaryRootDescription
import com.example.witcherbestiary.root.view.BestiaryRootView
import com.example.witcherbestiary.root.view.description.BestiaryRootViewDescription

interface BestiaryRootComponent : RootComponent<BestiaryRootViewDescription, BestiaryRootDescription, BestiaryRootView> {
    sealed class Input
    sealed class Output
}