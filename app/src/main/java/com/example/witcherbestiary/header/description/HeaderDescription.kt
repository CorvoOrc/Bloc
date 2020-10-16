package com.example.witcherbestiary.header.description

import com.example.bloc.description.ComponentDescription
import com.example.witcherbestiary.header.view.description.HeaderViewDescription

interface HeaderDescription : ComponentDescription<HeaderViewDescription> {
    val text: String
}