package com.example.witcherbestiary.header.description

import com.example.witcherbestiary.header.view.description.HeaderViewDescription

data class HeaderDescriptionImpl(
        override val id: String,
        override val text: String,
        override val view: HeaderViewDescription
) : HeaderDescription