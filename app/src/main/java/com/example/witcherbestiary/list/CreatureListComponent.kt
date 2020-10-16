package com.example.witcherbestiary.list

import com.example.witcherbestiary.card.CardComponent
import com.example.witcherbestiary.card.description.CardDescription
import com.example.bloc.component.CollectionComponent
import com.example.witcherbestiary.card.view.CardView
import com.example.witcherbestiary.card.view.description.CardViewDescription
import com.example.witcherbestiary.list.description.ListDescription
import com.example.witcherbestiary.list.view.CreatureListView
import com.example.witcherbestiary.list.view.description.CreatureListViewDescription
import com.example.witcherbestiary.model.Creature

interface CreatureListComponent : CollectionComponent<CardViewDescription, CardDescription, CardView, CardComponent, CreatureListViewDescription, ListDescription, CreatureListView> {
    interface ViewEvents {
        fun prepareCreatingItems()
        fun createItem(item: Creature): CardView
    }

    sealed class Input
    sealed class Output {
        data class Selected(val item: Creature?) : Output()
    }
}