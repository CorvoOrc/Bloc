package com.example.witcherbestiary.tab.view.description

import androidx.compose.ui.graphics.Color

data class TabRowViewDescriptionImpl(
        override val id: String,
        override val backgroundColor: Color,
        override val contentColor: Color,
        override val fontSize: Int,
        override val maxLines: Int
) : TabRowViewDescription