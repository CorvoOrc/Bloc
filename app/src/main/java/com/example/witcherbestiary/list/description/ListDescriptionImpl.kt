package com.example.witcherbestiary.list.description

import com.example.witcherbestiary.card.description.CardDescription
import com.example.witcherbestiary.list.view.description.CreatureListViewDescription

data class ListDescriptionImpl(
        override val id: String,
        override val view: CreatureListViewDescription,
        override val creature: CardDescription
) : ListDescription