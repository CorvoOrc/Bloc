package com.example.witcherbestiary.infoSlots

import com.example.bloc.component.CollectionComponent
import com.example.witcherbestiary.infoSlot.InfoSlotComponent
import com.example.witcherbestiary.infoSlot.description.InfoSlotDescription
import com.example.witcherbestiary.infoSlot.view.InfoSlotView
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription
import com.example.witcherbestiary.infoSlots.description.InfoSlotsDescription
import com.example.witcherbestiary.infoSlots.view.InfoSlotsView
import com.example.witcherbestiary.infoSlots.view.description.InfoSlotsViewDescription
import com.example.witcherbestiary.model.Creature

interface InfoSlotsComponent : CollectionComponent<InfoSlotViewDescription, InfoSlotDescription, InfoSlotView, InfoSlotComponent, InfoSlotsViewDescription, InfoSlotsDescription, InfoSlotsView> {
    interface ViewEvents {
        val itemsView: List<InfoSlotView>
    }

    sealed class Input {
        data class SetIndex(val index: Int) : Input()
        data class SetItem(val item: Creature) : Input()
    }
    sealed class Output
}