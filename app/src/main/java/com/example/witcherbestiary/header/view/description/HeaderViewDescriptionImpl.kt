package com.example.witcherbestiary.header.view.description

import androidx.compose.ui.graphics.Color

data class HeaderViewDescriptionImpl(
        override val id: String,
        override val backgroundColor: Color,
        override val contentColor: Color,
        override val backIsActive: Boolean,
        override val forwardIsActive: Boolean,
        override val navigationWidth: Int,
        override val actionWidth: Int
) : HeaderViewDescription