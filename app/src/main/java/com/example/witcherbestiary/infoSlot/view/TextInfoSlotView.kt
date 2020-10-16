package com.example.witcherbestiary.infoSlot.view

import androidx.compose.runtime.Composable
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.infoSlot.InfoSlotComponent
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription
import com.example.witcherbestiary.text.view.TextView
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class TextInfoSlotView @Inject constructor() : ViewBase<InfoSlotViewDescription, Any, InfoSlotComponent.ViewEvents>(),
        InfoSlotView
{
    private lateinit var childView: TextView

    override fun init(description: InfoSlotViewDescription, state: StateFlow<*>, events: Any?) {
        super.init(description, state, events)

        childView = this.events!!.childView as TextView
    }

    @Composable
    override fun render() {
        childView.render()
    }
}