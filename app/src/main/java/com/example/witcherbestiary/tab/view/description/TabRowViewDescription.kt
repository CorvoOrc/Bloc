package com.example.witcherbestiary.tab.view.description

import androidx.compose.ui.graphics.Color
import com.example.bloc.description.ViewDescription

interface TabRowViewDescription : ViewDescription {
    val backgroundColor: Color
    val contentColor: Color
    val fontSize: Int
    val maxLines: Int
}