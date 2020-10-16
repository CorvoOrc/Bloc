package com.example.witcherbestiary.infoSlots.description

import com.example.witcherbestiary.infoSlot.description.InfoSlotDescription
import com.example.witcherbestiary.infoSlots.view.description.InfoSlotsViewDescription

data class InfoSlotsDescriptionImpl(
        override val id: String,
        override val view: InfoSlotsViewDescription,
        override val items: List<InfoSlotDescription>
) : InfoSlotsDescription