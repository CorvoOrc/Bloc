package com.example.witcherbestiary.infoSlot.description

import com.example.bloc.description.Description
import com.example.bloc.description.TypedComponentDescription
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription

interface InfoSlotDescription : TypedComponentDescription<InfoSlotViewDescription> {
    val child: Description
}