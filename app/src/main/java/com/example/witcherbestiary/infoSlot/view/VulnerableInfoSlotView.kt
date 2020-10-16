package com.example.witcherbestiary.infoSlot.view

import androidx.compose.runtime.Composable
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.infoSlot.InfoSlotComponent
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription
import com.example.witcherbestiary.vulnerable.view.CreatureVulnerableView
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class VulnerableInfoSlotView @Inject constructor() : ViewBase<InfoSlotViewDescription, Any, InfoSlotComponent.ViewEvents>(),
        InfoSlotView
{
    private lateinit var childView: CreatureVulnerableView

    override fun init(description: InfoSlotViewDescription, state: StateFlow<*>, events: Any?) {
        super.init(description, state, events)

        childView = this.events!!.childView as CreatureVulnerableView
    }

    @Composable
    override fun render() {
        childView.render()
    }
}