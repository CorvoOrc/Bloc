package com.example.witcherbestiary.info.description

import com.example.witcherbestiary.info.view.description.InfoViewDescription
import com.example.witcherbestiary.infoSlots.description.InfoSlotsDescription
import com.example.witcherbestiary.tab.description.TabRowDescription

data class InfoDescriptionImpl(
        override val id: String,
        override val view: InfoViewDescription,
        override val tabRow: TabRowDescription,
        override val slots: InfoSlotsDescription
) : InfoDescription