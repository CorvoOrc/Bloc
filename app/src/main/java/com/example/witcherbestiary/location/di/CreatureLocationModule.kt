package com.example.witcherbestiary.location.di

import com.example.witcherbestiary.location.CreatureLocationComponent
import com.example.witcherbestiary.location.CreatureLocationComponentImpl
import com.example.witcherbestiary.location.store.CreatureLocationStore
import com.example.witcherbestiary.location.store.CreatureLocationStoreImpl
import com.example.witcherbestiary.location.view.CreatureLocationView
import com.example.witcherbestiary.location.view.CreatureLocationViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class CreatureLocationModule {
    @Binds
    abstract fun bindComponent(component: CreatureLocationComponentImpl): CreatureLocationComponent

    @Binds
    abstract fun bindStore(store: CreatureLocationStoreImpl): CreatureLocationStore

    @Binds
    abstract fun bindView(view: CreatureLocationViewImpl): CreatureLocationView
}