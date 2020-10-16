package com.example.witcherbestiary.card.view.description

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorStop
import com.example.bloc.description.ViewDescription

interface CardViewDescription : ViewDescription {
    val padding: Int
    val height: Int
    val colorStopA: ColorStop
    val colorStopB: ColorStop
    val startX: Float
    val borderWidth: Int
    val borderColor: Color
    val borderShape: Int
    val imagePadding: Int
    val textOffsetX: Int
    val textOffsetY: Int
    val textColor: Color
    val fontSize: Int
    val maxTextLines: Int
}