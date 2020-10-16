package com.example.witcherbestiary.infoSlots.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.bloc.view.CollectionViewBase
import com.example.witcherbestiary.infoSlot.view.InfoSlotView
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription
import com.example.witcherbestiary.infoSlots.InfoSlotsComponent
import com.example.witcherbestiary.infoSlots.store.InfoSlotsStore
import com.example.witcherbestiary.infoSlots.view.description.InfoSlotsViewDescription
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class InfoSlotsViewImpl @Inject constructor() : CollectionViewBase<InfoSlotsViewDescription, InfoSlotViewDescription, InfoSlotView, InfoSlotsStore.State, InfoSlotsComponent.ViewEvents>(),
        InfoSlotsView
{
    override fun init(description: InfoSlotsViewDescription, state: StateFlow<*>, events: Any?) {
        super.init(description, state, events)

        addAll(this.events!!.itemsView)
    }

    @Composable
    override fun render() {
        val state = state.collectAsState()

        items[state.value.index].render()
    }
}