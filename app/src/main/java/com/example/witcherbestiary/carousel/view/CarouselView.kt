package com.example.witcherbestiary.carousel.view

import com.example.witcherbestiary.carousel.view.description.CarouselViewDescription
import com.example.witcherbestiary.carouselSlot.view.CarouselSlotView
import com.example.witcherbestiary.carouselSlot.view.description.CarouselSlotViewDescription
import com.example.bloc.view.CollectionView

interface CarouselView : CollectionView<CarouselViewDescription, CarouselSlotViewDescription, CarouselSlotView>