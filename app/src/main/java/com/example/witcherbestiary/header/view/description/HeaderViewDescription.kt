package com.example.witcherbestiary.header.view.description

import androidx.compose.ui.graphics.Color
import com.example.bloc.description.ViewDescription

interface HeaderViewDescription : ViewDescription {
    val backgroundColor: Color
    val contentColor: Color
    val backIsActive: Boolean
    val forwardIsActive: Boolean
    val navigationWidth: Int
    val actionWidth: Int
}