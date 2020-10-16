package com.example.witcherbestiary.vulnerable.view.description

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

data class CreatureVulnerableViewDescriptionImpl(
        override val id: String,
        override val textColor: Color,
        override val textAlign: TextAlign,
        override val padding: Int
) : CreatureVulnerableViewDescription