package com.example.witcherbestiary.info.description

import com.example.bloc.description.ComponentDescription
import com.example.witcherbestiary.info.view.description.InfoViewDescription
import com.example.witcherbestiary.infoSlots.description.InfoSlotsDescription
import com.example.witcherbestiary.tab.description.TabRowDescription

interface InfoDescription : ComponentDescription<InfoViewDescription> {
    val tabRow: TabRowDescription
    val slots: InfoSlotsDescription
}