package com.example.witcherbestiary.infoSlot.di

import com.example.witcherbestiary.infoSlot.di.factory.view.InfoSlotViewFactory
import com.example.witcherbestiary.infoSlot.di.factory.view.InfoSlotViewFactoryImpl
import com.example.witcherbestiary.infoSlot.view.InfoSlotView
import com.example.witcherbestiary.infoSlot.view.LocationInfoSlotView
import com.example.witcherbestiary.infoSlot.view.TextInfoSlotView
import com.example.witcherbestiary.infoSlot.view.VulnerableInfoSlotView
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
internal abstract class InfoSlotViewModule {
    @Binds
    abstract fun bindViewFactory(factory: InfoSlotViewFactoryImpl): InfoSlotViewFactory

    @Binds
    @IntoMap
    @StringKey("about")
    abstract fun bindAbout(infoSlot: TextInfoSlotView) : InfoSlotView

    @Binds
    @IntoMap
    @StringKey("vulnerable")
    abstract fun bindVulnerable(infoSlot: VulnerableInfoSlotView): InfoSlotView

    @Binds
    @IntoMap
    @StringKey("location")
    abstract fun bindLocation(infoSlot: LocationInfoSlotView): InfoSlotView
}