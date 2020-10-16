package com.example.witcherbestiary.infoSlot.di.factory

import com.example.witcherbestiary.infoSlot.InfoSlotComponent
import javax.inject.Inject
import javax.inject.Provider

class InfoSlotFactoryImpl @Inject constructor(
        private val items: Map<String, @JvmSuppressWildcards Provider<InfoSlotComponent>>
) : InfoSlotFactory {
    override fun build(key: String): InfoSlotComponent {
        return items.getValue(key).get()
    }
}