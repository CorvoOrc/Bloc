package com.example.witcherbestiary.infoSlot.description

import com.example.bloc.description.Description
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription

data class InfoSlotDescriptionImpl(
        override val id: String,
        override val type: String,
        override val view: InfoSlotViewDescription,
        override val child: Description
) : InfoSlotDescription