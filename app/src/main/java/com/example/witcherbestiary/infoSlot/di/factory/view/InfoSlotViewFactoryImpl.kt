package com.example.witcherbestiary.infoSlot.di.factory.view

import com.example.witcherbestiary.infoSlot.view.InfoSlotView
import javax.inject.Inject
import javax.inject.Provider

class InfoSlotViewFactoryImpl @Inject constructor(
    private val items: Map<String, @JvmSuppressWildcards Provider<InfoSlotView>>
) : InfoSlotViewFactory {
    override fun build(key: String): InfoSlotView {
        return items.getValue(key).get()
    }
}