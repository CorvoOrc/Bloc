package com.example.witcherbestiary.root.di

import com.example.bloc.router.Router
import com.example.bloc.router.RouterImpl
import com.example.witcherbestiary.root.BestiaryRootComponent
import com.example.witcherbestiary.root.BestiaryRootComponentImpl
import com.example.witcherbestiary.root.view.BestiaryRootView
import com.example.witcherbestiary.root.view.BestiaryRootViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class RootModule {
    @Binds
    abstract fun bindComponent(component: BestiaryRootComponentImpl): BestiaryRootComponent

    @Binds
    abstract fun bindRouter(router: RouterImpl): Router

    @Binds
    abstract fun bindView(view: BestiaryRootViewImpl): BestiaryRootView
}