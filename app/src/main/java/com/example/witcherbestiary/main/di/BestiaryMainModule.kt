package com.example.witcherbestiary.main.di

import com.example.witcherbestiary.main.BestiaryMainComponent
import com.example.witcherbestiary.main.BestiaryMainComponentImpl
import com.example.witcherbestiary.main.store.BestiaryMainStore
import com.example.witcherbestiary.main.store.BestiaryMainStoreImpl
import com.example.witcherbestiary.main.view.BestiaryMainView
import com.example.witcherbestiary.main.view.BestiaryMainViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class BestiaryMainModule {
    @Binds
    abstract fun bindComponent(component: BestiaryMainComponentImpl): BestiaryMainComponent

    @Binds
    abstract fun bindStore(store: BestiaryMainStoreImpl): BestiaryMainStore

    @Binds
    abstract fun bindView(view: BestiaryMainViewImpl): BestiaryMainView
}