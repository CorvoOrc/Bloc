package com.example.witcherbestiary.infoSlots.description

import com.example.bloc.description.ComponentDescription
import com.example.witcherbestiary.infoSlot.description.InfoSlotDescription
import com.example.witcherbestiary.infoSlots.view.description.InfoSlotsViewDescription

interface InfoSlotsDescription : ComponentDescription<InfoSlotsViewDescription> {
    val items: List<InfoSlotDescription>
}