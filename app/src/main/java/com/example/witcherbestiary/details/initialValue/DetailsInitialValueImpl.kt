package com.example.witcherbestiary.details.initialValue

import com.example.witcherbestiary.carousel.initialValue.CarouselInitialValueImpl
import com.example.witcherbestiary.header.initialValue.HeaderInitialValue
import com.example.witcherbestiary.info.initialValue.InfoInitialValue
import com.example.witcherbestiary.model.Creature
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailsInitialValueImpl(
        override val item: Creature? = null,
        override val header: HeaderInitialValue? = null,
        override val carousel: CarouselInitialValueImpl? = null,
        override val info: InfoInitialValue? = null
) : DetailsInitialValue