package com.example.witcherbestiary.carouselSlot.di

import com.example.witcherbestiary.carouselSlot.CarouselSlotComponent
import com.example.witcherbestiary.carouselSlot.CarouselSlotComponentImpl
import com.example.witcherbestiary.carouselSlot.store.CarouselSlotStore
import com.example.witcherbestiary.carouselSlot.store.CarouselSlotStoreImpl
import com.example.witcherbestiary.carouselSlot.view.CarouselSlotView
import com.example.witcherbestiary.carouselSlot.view.CarouselSlotViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class CarouselSlotModule {
    @Binds
    abstract fun bindComponent(component: CarouselSlotComponentImpl): CarouselSlotComponent

    @Binds
    abstract fun bindStore(store: CarouselSlotStoreImpl): CarouselSlotStore

    @Binds
    abstract fun bindView(view: CarouselSlotViewImpl): CarouselSlotView
}