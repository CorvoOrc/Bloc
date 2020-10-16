package com.example.witcherbestiary.location.description

import com.example.witcherbestiary.location.view.description.CreatureLocationViewDescription

data class CreatureLocationDescriptionImpl(
        override val id: String,
        override val view: CreatureLocationViewDescription
) : CreatureLocationDescription