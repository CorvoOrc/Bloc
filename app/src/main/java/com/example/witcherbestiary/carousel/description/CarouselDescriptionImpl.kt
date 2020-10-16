package com.example.witcherbestiary.carousel.description

import com.example.witcherbestiary.carousel.view.description.CarouselViewDescription
import com.example.witcherbestiary.carouselSlot.description.CarouselSlotDescription

data class CarouselDescriptionImpl(
        override val id: String,
        override val view: CarouselViewDescription,
        override val slot: CarouselSlotDescription
) : CarouselDescription