package com.example.witcherbestiary.details.description

import com.example.witcherbestiary.carousel.description.CarouselDescription
import com.example.witcherbestiary.details.view.description.BestiaryDetailsViewDescription
import com.example.witcherbestiary.header.description.HeaderDescription
import com.example.witcherbestiary.info.description.InfoDescription

data class BestiaryDetailsDescriptionImpl(
        override val id: String,
        override val view: BestiaryDetailsViewDescription,
        override val header: HeaderDescription,
        override val carousel: CarouselDescription,
        override val info: InfoDescription
) : BestiaryDetailsDescription