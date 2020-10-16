package com.example.witcherbestiary.details.initialValue

import com.example.witcherbestiary.carousel.initialValue.CarouselInitialValueImpl
import com.example.bloc.value.InitialValue
import com.example.witcherbestiary.header.initialValue.HeaderInitialValue
import com.example.witcherbestiary.info.initialValue.InfoInitialValue
import com.example.witcherbestiary.model.Creature

interface DetailsInitialValue : InitialValue {
    val item: Creature?
    val header: HeaderInitialValue?
    val carousel: CarouselInitialValueImpl?
    val info: InfoInitialValue?
}