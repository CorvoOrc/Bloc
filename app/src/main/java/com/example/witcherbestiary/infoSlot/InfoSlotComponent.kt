package com.example.witcherbestiary.infoSlot

import com.example.bloc.component.Component
import com.example.bloc.view.View
import com.example.witcherbestiary.infoSlot.description.InfoSlotDescription
import com.example.witcherbestiary.infoSlot.view.InfoSlotView
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription
import com.example.witcherbestiary.model.Creature

interface InfoSlotComponent : Component<InfoSlotViewDescription, InfoSlotDescription, InfoSlotView> {
    interface ViewEvents {
        val childView: View<*>
    }

    sealed class Input {
        data class SetItem(val item: Creature) : Input()
    }
    sealed class Output
}