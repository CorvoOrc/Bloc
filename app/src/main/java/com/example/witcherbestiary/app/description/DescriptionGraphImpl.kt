package com.example.witcherbestiary.app.description

import com.example.bloc.description.DescriptionGraph
import com.example.witcherbestiary.root.description.BestiaryRootDescription
import javax.inject.Inject

data class DescriptionGraphImpl @Inject constructor(
        override val id: String,
        override val rootComponent: BestiaryRootDescription,
        override val database: String
) : DescriptionGraph<BestiaryRootDescription>