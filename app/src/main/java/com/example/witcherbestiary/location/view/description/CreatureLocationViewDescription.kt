package com.example.witcherbestiary.location.view.description

import androidx.compose.ui.graphics.Color
import com.example.bloc.description.ViewDescription

interface CreatureLocationViewDescription : ViewDescription {
    val padding: Int
    val nameColor: Color
    val locationColor: Color
}