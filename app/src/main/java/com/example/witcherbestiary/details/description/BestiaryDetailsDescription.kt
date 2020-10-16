package com.example.witcherbestiary.details.description

import com.example.witcherbestiary.carousel.description.CarouselDescription
import com.example.bloc.description.ComponentDescription
import com.example.witcherbestiary.details.view.description.BestiaryDetailsViewDescription
import com.example.witcherbestiary.header.description.HeaderDescription
import com.example.witcherbestiary.info.description.InfoDescription

interface BestiaryDetailsDescription : ComponentDescription<BestiaryDetailsViewDescription> {
    val header: HeaderDescription
    val carousel: CarouselDescription
    val info: InfoDescription
}