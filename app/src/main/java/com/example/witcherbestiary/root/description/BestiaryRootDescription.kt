package com.example.witcherbestiary.root.description

import com.example.bloc.description.RootDescription
import com.example.witcherbestiary.details.description.BestiaryDetailsDescription
import com.example.witcherbestiary.main.description.BestiaryMainDescription
import com.example.witcherbestiary.root.view.description.BestiaryRootViewDescription

interface BestiaryRootDescription : RootDescription<BestiaryRootViewDescription> {
    val main: BestiaryMainDescription
    val details: BestiaryDetailsDescription
}