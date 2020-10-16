package com.example.witcherbestiary.card.description

import com.example.witcherbestiary.card.view.description.CardViewDescription

data class CardDescriptionImpl(
        override val id: String,
        override val view: CardViewDescription
) : CardDescription