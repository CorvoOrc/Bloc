package com.example.witcherbestiary.list.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.witcherbestiary.card.view.CardView
import com.example.witcherbestiary.card.view.description.CardViewDescription
import com.example.bloc.view.CollectionViewBase
import com.example.witcherbestiary.list.CreatureListComponent
import com.example.witcherbestiary.list.store.CreatureListStore
import com.example.witcherbestiary.list.view.description.CreatureListViewDescription
import javax.inject.Inject

internal class CreatureListViewImpl @Inject constructor() :
        CollectionViewBase<CreatureListViewDescription, CardViewDescription, CardView, CreatureListStore.State, CreatureListComponent.ViewEvents>(),
        CreatureListView {
    @Composable
    override fun render() {
        val state = state.collectAsState()

        clear()
        events?.prepareCreatingItems()
        addAll(
                state.value.items.map {
                    events!!.createItem(it)
                }
        )
        for (item in items)
            item.render()
    }
}