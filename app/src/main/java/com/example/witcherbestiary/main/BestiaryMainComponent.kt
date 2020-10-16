package com.example.witcherbestiary.main

import com.example.bloc.component.Component
import com.example.witcherbestiary.header.view.HeaderView
import com.example.witcherbestiary.list.view.CreatureListView
import com.example.witcherbestiary.main.description.BestiaryMainDescription
import com.example.witcherbestiary.main.view.BestiaryMainView
import com.example.witcherbestiary.main.view.description.BestiaryMainViewDescription
import com.example.witcherbestiary.model.Creature

interface BestiaryMainComponent : Component<BestiaryMainViewDescription, BestiaryMainDescription, BestiaryMainView> {
    interface ViewEvents {
        val headerView: HeaderView
        val listView: CreatureListView

        fun setScroll(value: Float)
    }

    sealed class Input
    sealed class Output {
        data class Selected(val item: Creature?) : Output()
    }
}