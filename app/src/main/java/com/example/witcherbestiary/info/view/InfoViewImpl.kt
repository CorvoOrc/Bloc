package com.example.witcherbestiary.info.view

import androidx.compose.runtime.Composable
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.info.InfoComponent
import com.example.witcherbestiary.info.view.description.InfoViewDescription
import com.example.witcherbestiary.infoSlots.view.InfoSlotsView
import com.example.witcherbestiary.tab.view.TabRowView
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class InfoViewImpl @Inject constructor() : ViewBase<InfoViewDescription, Any, InfoComponent.ViewEvents>(), InfoView {
    private lateinit var tabRowView: TabRowView
    private lateinit var infoSlotsView: InfoSlotsView

    override fun init(description: InfoViewDescription, state: StateFlow<*>, events: Any?) {
        super.init(description, state, events)

        infoSlotsView = this.events!!.infoSlotsView
        tabRowView = this.events!!.tabView
    }

    @Composable
    override fun render() {
        tabRowView.render()
        infoSlotsView.render()
    }
}