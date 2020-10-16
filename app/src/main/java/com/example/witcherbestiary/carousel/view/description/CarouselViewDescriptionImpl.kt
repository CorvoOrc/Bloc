package com.example.witcherbestiary.carousel.view.description

data class CarouselViewDescriptionImpl(
        override val id: String,
        override val pagerHeight: Int,
        override val pagerRowWidth: Int,
        override val unselectedScale: Float
) : CarouselViewDescription