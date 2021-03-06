package com.example.witcherbestiary.text.view.description

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.bloc.description.ViewDescription

interface TextViewDescription : ViewDescription {
    val textColor: Color
    val textAlign: TextAlign
    val padding: Int
}