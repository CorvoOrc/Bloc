package com.example.witcherbestiary.location.view.description

import androidx.compose.ui.graphics.Color

data class CreatureLocationViewDescriptionImpl(
        override val id: String,
        override val padding: Int,
        override val nameColor: Color,
        override val locationColor: Color
) : CreatureLocationViewDescription