package com.example.witcherbestiary.app.di

import com.example.witcherbestiary.carousel.di.CarouselAssembler
import com.example.witcherbestiary.carouselSlot.di.CarouselSlotAssembler
import com.example.witcherbestiary.card.di.CardAssembler
import com.example.witcherbestiary.details.di.BestiaryDetailsAssembler
import com.example.witcherbestiary.header.di.HeaderAssembler
import com.example.witcherbestiary.info.di.InfoAssembler
import com.example.witcherbestiary.infoSlot.di.InfoSlotAssembler
import com.example.witcherbestiary.infoSlots.di.InfoSlotsAssembler
import com.example.witcherbestiary.list.di.ListAssembler
import com.example.witcherbestiary.location.di.CreatureLocationAssembler
import com.example.witcherbestiary.main.di.BestiaryMainAssembler
import com.example.witcherbestiary.root.di.RootAssembler
import com.example.witcherbestiary.tab.di.TabRowAssembler
import com.example.witcherbestiary.text.di.TextAssembler
import com.example.witcherbestiary.vulnerable.di.CreatureVulnerableAssembler
import dagger.Module

@Module(
        subcomponents = [
            RootAssembler::class,
            BestiaryDetailsAssembler::class,
            BestiaryMainAssembler::class,
            ListAssembler::class,
            HeaderAssembler::class,
            CardAssembler::class,
            CarouselAssembler::class,
            CarouselSlotAssembler::class,
            InfoAssembler::class,
            InfoSlotsAssembler::class,
            InfoSlotAssembler::class,
            TabRowAssembler::class,
            TextAssembler::class,
            CreatureLocationAssembler::class,
            CreatureVulnerableAssembler::class
        ]
)
object SubcomponentsModule