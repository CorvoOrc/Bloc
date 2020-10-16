package com.example.witcherbestiary.carousel.description

import com.example.witcherbestiary.carousel.view.description.CarouselViewDescription
import com.example.witcherbestiary.carouselSlot.description.CarouselSlotDescription
import com.example.bloc.description.ComponentDescription

interface CarouselDescription : ComponentDescription<CarouselViewDescription> {
    val slot: CarouselSlotDescription
}