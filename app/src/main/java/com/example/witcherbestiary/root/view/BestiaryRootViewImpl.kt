package com.example.witcherbestiary.root.view

import androidx.compose.runtime.Composable
import com.example.bloc.view.RootViewBase
import com.example.bloc.view.RootViewEvents
import com.example.witcherbestiary.root.view.description.BestiaryRootViewDescription
import javax.inject.Inject

internal class BestiaryRootViewImpl @Inject constructor() : RootViewBase<BestiaryRootViewDescription, Any, RootViewEvents>(),
        BestiaryRootView
{
    @Composable
    override fun renderOut() {
    }
}