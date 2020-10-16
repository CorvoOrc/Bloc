package com.example.witcherbestiary.carousel.view.description

import com.example.bloc.description.ViewDescription

interface CarouselViewDescription : ViewDescription {
    val pagerHeight: Int
    val pagerRowWidth: Int
    val unselectedScale: Float
}