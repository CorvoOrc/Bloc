package com.example.witcherbestiary.details

import com.example.witcherbestiary.carousel.view.CarouselView
import com.example.bloc.component.Component
import com.example.witcherbestiary.details.description.BestiaryDetailsDescription
import com.example.witcherbestiary.details.view.BestiaryDetailsView
import com.example.witcherbestiary.details.view.description.BestiaryDetailsViewDescription
import com.example.witcherbestiary.header.view.HeaderView
import com.example.witcherbestiary.info.view.InfoView
import com.example.witcherbestiary.model.Creature

interface BestiaryDetailsComponent : Component<BestiaryDetailsViewDescription, BestiaryDetailsDescription, BestiaryDetailsView> {
    interface ViewEvents {
        val headerView: HeaderView
        val carouselView: CarouselView
        val infoView: InfoView
    }

    sealed class Input {
        data class Select(val item: Creature?): Input()
    }
    sealed class Output {
        object Finished : Output()
    }
}