package com.example.witcherbestiary.list.di

import com.example.witcherbestiary.list.CreatureListComponent
import com.example.witcherbestiary.list.CreatureListComponentImpl
import com.example.witcherbestiary.list.store.CreatureListStore
import com.example.witcherbestiary.list.store.CreatureListStoreImpl
import com.example.witcherbestiary.list.view.CreatureListView
import com.example.witcherbestiary.list.view.CreatureListViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class ListModule {
    @Binds
    abstract fun bindComponent(component: CreatureListComponentImpl): CreatureListComponent

    @Binds
    abstract fun bindStore(store: CreatureListStoreImpl): CreatureListStore

    @Binds
    abstract fun bindView(view: CreatureListViewImpl): CreatureListView
}