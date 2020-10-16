package com.example.witcherbestiary.infoSlot.view

import androidx.compose.runtime.Composable
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.infoSlot.InfoSlotComponent
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription
import com.example.witcherbestiary.location.view.CreatureLocationView
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class LocationInfoSlotView @Inject constructor() : ViewBase<InfoSlotViewDescription, Any, InfoSlotComponent.ViewEvents>(),
        InfoSlotView
{
    private lateinit var childView: CreatureLocationView

    override fun init(description: InfoSlotViewDescription, state: StateFlow<*>, events: Any?) {
        super.init(description, state, events)

        childView = this.events!!.childView as CreatureLocationView
    }

    @Composable
    override fun render() {
        childView.render()
    }
}