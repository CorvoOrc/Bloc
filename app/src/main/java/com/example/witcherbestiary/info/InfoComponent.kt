package com.example.witcherbestiary.info

import com.example.bloc.component.Component
import com.example.witcherbestiary.info.description.InfoDescription
import com.example.witcherbestiary.info.view.InfoView
import com.example.witcherbestiary.info.view.description.InfoViewDescription
import com.example.witcherbestiary.infoSlots.view.InfoSlotsView
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.tab.view.TabRowView

interface InfoComponent : Component<InfoViewDescription, InfoDescription, InfoView>{
    interface ViewEvents {
        val infoSlotsView: InfoSlotsView
        val tabView: TabRowView
    }

    sealed class Input {
        data class SetItem(val item: Creature) : Input()
    }
    sealed class  Output
}