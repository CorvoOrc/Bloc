package com.example.witcherbestiary.infoSlot.di

import com.example.witcherbestiary.infoSlot.description.InfoSlotDescription
import com.example.witcherbestiary.infoSlot.di.factory.view.InfoSlotViewFactory
import com.example.witcherbestiary.infoSlot.view.InfoSlotView
import dagger.Module
import dagger.Provides

@Module
object InfoSlotViewProvideModule {
    @Provides
    fun provideView(factory: InfoSlotViewFactory, description: InfoSlotDescription): InfoSlotView =
        factory.build(description.view.type)
}