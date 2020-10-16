package com.example.witcherbestiary.infoSlots.di

import com.example.witcherbestiary.infoSlots.InfoSlotsComponent
import com.example.witcherbestiary.infoSlots.InfoSlotsComponentImpl
import com.example.witcherbestiary.infoSlots.store.InfoSlotsStore
import com.example.witcherbestiary.infoSlots.store.InfoSlotsStoreImpl
import com.example.witcherbestiary.infoSlots.view.InfoSlotsView
import com.example.witcherbestiary.infoSlots.view.InfoSlotsViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class InfoSlotsModule {
    @Binds
    abstract fun bindComponent(component: InfoSlotsComponentImpl): InfoSlotsComponent

    @Binds
    abstract fun bindStore(store: InfoSlotsStoreImpl): InfoSlotsStore

    @Binds
    abstract fun bindView(view: InfoSlotsViewImpl): InfoSlotsView
}