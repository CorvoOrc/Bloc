package com.example.witcherbestiary.tab.di

import com.example.witcherbestiary.tab.TabRowComponent
import com.example.witcherbestiary.tab.TabRowComponentImpl
import com.example.witcherbestiary.tab.store.TabRowStore
import com.example.witcherbestiary.tab.store.TabRowStoreImpl
import com.example.witcherbestiary.tab.view.TabRowView
import com.example.witcherbestiary.tab.view.TabRowViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class TabRowModule {
    @Binds
    abstract fun bindComponent(component: TabRowComponentImpl): TabRowComponent

    @Binds
    abstract fun bindStore(store: TabRowStoreImpl): TabRowStore

    @Binds
    abstract fun bindView(view: TabRowViewImpl): TabRowView
}