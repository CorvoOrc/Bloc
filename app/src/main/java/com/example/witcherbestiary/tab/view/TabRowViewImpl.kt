package com.example.witcherbestiary.tab.view

import androidx.compose.foundation.Text
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.sp
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.tab.TabRowComponent
import com.example.witcherbestiary.tab.store.TabRowStore
import com.example.witcherbestiary.tab.view.description.TabRowViewDescription
import javax.inject.Inject

internal class TabRowViewImpl @Inject constructor() : ViewBase<TabRowViewDescription, TabRowStore.State, TabRowComponent.ViewEvents>(),
        TabRowView
{
    @Composable
    override fun render() {
        val state = state.collectAsState()

        TabRow(selectedTabIndex = state.value.index, backgroundColor = description.backgroundColor, contentColor = description.contentColor) {
            for (i in state.value.tabs.indices)
                Tab(
                        selected = false,
                        onClick = { events?.select(i) },
                        text = {
                            Text(state.value.tabs[i],
                                    fontSize = description.fontSize.sp,
                                    maxLines = description.maxLines
                            )
                        }
                )
        }
    }
}