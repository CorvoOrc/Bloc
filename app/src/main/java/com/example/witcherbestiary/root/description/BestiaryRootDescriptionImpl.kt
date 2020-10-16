package com.example.witcherbestiary.root.description

import com.example.witcherbestiary.details.description.BestiaryDetailsDescription
import com.example.witcherbestiary.main.description.BestiaryMainDescription
import com.example.witcherbestiary.root.view.description.BestiaryRootViewDescription

data class BestiaryRootDescriptionImpl(
        override val id: String,
        override val view: BestiaryRootViewDescription,
        override val main: BestiaryMainDescription,
        override val details: BestiaryDetailsDescription,
        override val initialComponent: String
) : BestiaryRootDescription