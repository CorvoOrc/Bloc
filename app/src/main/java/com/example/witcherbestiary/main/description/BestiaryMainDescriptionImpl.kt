package com.example.witcherbestiary.main.description

import com.example.witcherbestiary.header.description.HeaderDescription
import com.example.witcherbestiary.list.description.ListDescription
import com.example.witcherbestiary.main.view.description.BestiaryMainViewDescription

data class BestiaryMainDescriptionImpl(
        override val id: String,
        override val view: BestiaryMainViewDescription,
        override val header: HeaderDescription,
        override val list: ListDescription
) : BestiaryMainDescription