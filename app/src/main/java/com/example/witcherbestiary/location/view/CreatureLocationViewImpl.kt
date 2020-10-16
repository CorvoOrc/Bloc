package com.example.witcherbestiary.location.view

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.location.store.CreatureLocationStore
import com.example.witcherbestiary.location.view.description.CreatureLocationViewDescription
import javax.inject.Inject

internal class CreatureLocationViewImpl @Inject constructor() : ViewBase<CreatureLocationViewDescription, CreatureLocationStore.State, Any>(),
        CreatureLocationView
{
    @Composable
    override fun render(){
        val state = state.collectAsState()

        Column(modifier = Modifier.fillMaxSize()) {
            for (location in state.value.locations) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(description.padding.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = location.name,
                        color = description.nameColor
                    )
                    Text(
                        text = "{${location.x}; ${location.y}}",
                        color = description.locationColor
                    )
                }
            }
        }
    }
}