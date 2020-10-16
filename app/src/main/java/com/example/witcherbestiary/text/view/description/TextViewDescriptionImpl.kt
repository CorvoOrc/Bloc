package com.example.witcherbestiary.text.view.description

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

data class TextViewDescriptionImpl(
        override val id: String,
        override val textColor: Color,
        override val textAlign: TextAlign,
        override val padding: Int
) : TextViewDescription