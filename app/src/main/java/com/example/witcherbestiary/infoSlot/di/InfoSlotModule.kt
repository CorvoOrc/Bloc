package com.example.witcherbestiary.infoSlot.di

import com.example.witcherbestiary.infoSlot.InfoSlotComponent
import com.example.witcherbestiary.infoSlot.LocationInfoSlotComponent
import com.example.witcherbestiary.infoSlot.TextInfoSlotComponent
import com.example.witcherbestiary.infoSlot.VulnerableInfoSlotComponent
import com.example.witcherbestiary.infoSlot.di.factory.InfoSlotFactory
import com.example.witcherbestiary.infoSlot.di.factory.InfoSlotFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
internal abstract class InfoSlotModule {
    @Binds
    abstract fun bindFactory(factory: InfoSlotFactoryImpl): InfoSlotFactory

    @Binds
    @IntoMap
    @StringKey("about")
    abstract fun bindAbout(infoSlot: TextInfoSlotComponent) : InfoSlotComponent

    @Binds
    @IntoMap
    @StringKey("vulnerable")
    abstract fun bindVulnerable(infoSlot: VulnerableInfoSlotComponent): InfoSlotComponent

    @Binds
    @IntoMap
    @StringKey("location")
    abstract fun bindLocation(infoSlot: LocationInfoSlotComponent): InfoSlotComponent
}