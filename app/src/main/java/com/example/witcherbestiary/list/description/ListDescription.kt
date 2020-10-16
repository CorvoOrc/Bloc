package com.example.witcherbestiary.list.description

import com.example.witcherbestiary.card.description.CardDescription
import com.example.bloc.description.ComponentDescription
import com.example.witcherbestiary.list.view.description.CreatureListViewDescription

interface ListDescription : ComponentDescription<CreatureListViewDescription> {
    val creature: CardDescription
}