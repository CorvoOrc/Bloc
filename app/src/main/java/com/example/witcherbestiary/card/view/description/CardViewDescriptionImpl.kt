package com.example.witcherbestiary.card.view.description

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorStop

data class CardViewDescriptionImpl(
        override val id: String,
        override val padding: Int,
        override val height: Int,
        override val colorStopA: ColorStop,
        override val colorStopB: ColorStop,
        override val startX: Float,
        override val borderWidth: Int,
        override val borderColor: Color,
        override val borderShape: Int,
        override val imagePadding: Int,
        override val textOffsetX: Int,
        override val textOffsetY: Int,
        override val textColor: Color,
        override val fontSize: Int,
        override val maxTextLines: Int
) : CardViewDescription