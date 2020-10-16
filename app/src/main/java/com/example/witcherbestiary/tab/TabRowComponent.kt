package com.example.witcherbestiary.tab

import com.example.bloc.component.Component
import com.example.witcherbestiary.tab.description.TabRowDescription
import com.example.witcherbestiary.tab.view.TabRowView
import com.example.witcherbestiary.tab.view.description.TabRowViewDescription

interface TabRowComponent : Component<TabRowViewDescription, TabRowDescription, TabRowView> {
    interface ViewEvents {
        fun select(index: Int)
    }

    sealed class Input
    sealed class Output {
        data class Selected(val index: Int) : Output()
    }
}