package com.example.witcherbestiary.tab.description

import com.example.bloc.description.ComponentDescription
import com.example.witcherbestiary.tab.view.description.TabRowViewDescription

interface TabRowDescription : ComponentDescription<TabRowViewDescription> {
    val tabs: List<String>
    val startIndex: Int
}