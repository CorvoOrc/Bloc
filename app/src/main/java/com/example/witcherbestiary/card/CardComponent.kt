package com.example.witcherbestiary.card

import com.example.witcherbestiary.card.description.CardDescription
import com.example.bloc.component.Component
import com.example.witcherbestiary.card.view.CardView
import com.example.witcherbestiary.card.view.description.CardViewDescription
import com.example.witcherbestiary.model.Creature

interface CardComponent : Component<CardViewDescription, CardDescription, CardView> {
    interface ViewEvents {
        fun select(item: Creature)
    }

    sealed class Input
    sealed class Output {
        data class Selected(val item: Creature?) : Output()
    }
}