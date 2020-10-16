package com.example.witcherbestiary.header.di

import com.example.witcherbestiary.header.HeaderComponent
import com.example.witcherbestiary.header.HeaderComponentImpl
import com.example.witcherbestiary.header.store.HeaderStore
import com.example.witcherbestiary.header.store.HeaderStoreImpl
import com.example.witcherbestiary.header.view.HeaderView
import com.example.witcherbestiary.header.view.HeaderViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class HeaderModule {
    @Binds
    abstract fun bindComponent(component: HeaderComponentImpl): HeaderComponent

    @Binds
    abstract fun bindStore(store: HeaderStoreImpl): HeaderStore

    @Binds
    abstract fun bindView(view: HeaderViewImpl): HeaderView
}