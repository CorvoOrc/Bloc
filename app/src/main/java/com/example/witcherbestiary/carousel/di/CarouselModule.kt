package com.example.witcherbestiary.carousel.di

import com.example.witcherbestiary.carousel.CarouselComponent
import com.example.witcherbestiary.carousel.CarouselComponentImpl
import com.example.witcherbestiary.carousel.store.CarouselStore
import com.example.witcherbestiary.carousel.store.CarouselStoreImpl
import com.example.witcherbestiary.carousel.view.CarouselView
import com.example.witcherbestiary.carousel.view.CarouselViewImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class CarouselModule {
    @Binds
    abstract fun bindComponent(component: CarouselComponentImpl): CarouselComponent

    @Binds
    abstract fun bindStore(store: CarouselStoreImpl): CarouselStore

    @Binds
    abstract fun bindView(view: CarouselViewImpl): CarouselView
}