package com.example.witcherbestiary.info.di

import com.example.witcherbestiary.info.InfoComponent
import com.example.witcherbestiary.info.InfoComponentImpl
import com.example.witcherbestiary.info.store.InfoStore
import com.example.witcherbestiary.info.store.InfoStoreImpl
import com.example.witcherbestiary.info.view.InfoView
import com.example.witcherbestiary.info.view.InfoViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class InfoModule {
    @Binds
    abstract fun bindComponent(component: InfoComponentImpl): InfoComponent

    @Binds
    abstract fun bindStore(store: InfoStoreImpl): InfoStore

    @Binds
    abstract fun bindView(view: InfoViewImpl): InfoView
}