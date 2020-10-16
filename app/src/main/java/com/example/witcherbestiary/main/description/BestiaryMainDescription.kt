package com.example.witcherbestiary.main.description

import com.example.bloc.description.ComponentDescription
import com.example.witcherbestiary.header.description.HeaderDescription
import com.example.witcherbestiary.list.description.ListDescription
import com.example.witcherbestiary.main.view.description.BestiaryMainViewDescription

interface BestiaryMainDescription : ComponentDescription<BestiaryMainViewDescription> {
    val header: HeaderDescription
    val list: ListDescription
}