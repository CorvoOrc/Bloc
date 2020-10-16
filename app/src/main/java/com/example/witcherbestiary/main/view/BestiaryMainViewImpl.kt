package com.example.witcherbestiary.main.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.header.view.HeaderView
import com.example.witcherbestiary.list.view.CreatureListView
import com.example.witcherbestiary.main.BestiaryMainComponent
import com.example.witcherbestiary.main.store.BestiaryMainStore
import com.example.witcherbestiary.main.view.description.BestiaryMainViewDescription
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class BestiaryMainViewImpl @Inject constructor() : ViewBase<BestiaryMainViewDescription, BestiaryMainStore.State, BestiaryMainComponent.ViewEvents>(),
        BestiaryMainView
{
    lateinit var headerView: HeaderView
        private set
    lateinit var listView: CreatureListView
        private set

    override fun init(description: BestiaryMainViewDescription, state: StateFlow<*>, events: Any?) {
        super.init(description, state, events)

        this.headerView = this.events!!.headerView
        this.listView = this.events!!.listView
    }

    @Composable
    override fun render() {
        Column(modifier = Modifier.fillMaxHeight().background(description.backgroundColor)) {
            headerView.render()
            val scrollState = rememberScrollState(state.value.scrollPos)
            updateScrollState(scrollState)
            ScrollableColumn(scrollState = scrollState, modifier = Modifier) {
                listView.render()
            }
        }
    }

    @Composable
    private fun updateScrollState(state: ScrollState) {
        events?.setScroll(state.value)
    }
}