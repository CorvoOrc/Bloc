package com.example.witcherbestiary.app.di

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.bloc.description.DescriptionGraph
import com.example.witcherbestiary.app.description.DescriptionGraphImpl
import com.example.witcherbestiary.card.description.CardDescriptionImpl
import com.example.witcherbestiary.card.view.description.CardViewDescriptionImpl
import com.example.witcherbestiary.carousel.description.CarouselDescriptionImpl
import com.example.witcherbestiary.carousel.view.description.CarouselViewDescriptionImpl
import com.example.witcherbestiary.carouselSlot.description.CarouselSlotDescriptionImpl
import com.example.witcherbestiary.carouselSlot.view.description.CarouselSlotViewDescriptionImpl
import com.example.witcherbestiary.details.description.BestiaryDetailsDescriptionImpl
import com.example.witcherbestiary.details.view.description.BestiaryDetailsViewDescriptionImpl
import com.example.witcherbestiary.header.description.HeaderDescriptionImpl
import com.example.witcherbestiary.header.view.description.HeaderViewDescriptionImpl
import com.example.witcherbestiary.info.description.InfoDescriptionImpl
import com.example.witcherbestiary.info.view.description.InfoViewDescriptionImpl
import com.example.witcherbestiary.infoSlot.description.InfoSlotDescriptionImpl
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescriptionImpl
import com.example.witcherbestiary.infoSlots.description.InfoSlotsDescriptionImpl
import com.example.witcherbestiary.infoSlots.view.description.InfoSlotsViewDescriptionImpl
import com.example.witcherbestiary.list.description.ListDescriptionImpl
import com.example.witcherbestiary.list.view.description.CreatureListViewDescriptionImpl
import com.example.witcherbestiary.location.description.CreatureLocationDescriptionImpl
import com.example.witcherbestiary.location.view.description.CreatureLocationViewDescriptionImpl
import com.example.witcherbestiary.main.description.BestiaryMainDescriptionImpl
import com.example.witcherbestiary.main.view.description.BestiaryMainViewDescriptionImpl
import com.example.witcherbestiary.root.description.BestiaryRootDescription
import com.example.witcherbestiary.root.description.BestiaryRootDescriptionImpl
import com.example.witcherbestiary.root.view.description.BestiaryRootViewDescriptionImpl
import com.example.witcherbestiary.tab.description.TabRowDescriptionImpl
import com.example.witcherbestiary.tab.view.description.TabRowViewDescriptionImpl
import com.example.witcherbestiary.text.description.TextDescriptionImpl
import com.example.witcherbestiary.text.view.description.TextViewDescriptionImpl
import com.example.witcherbestiary.vulnerable.description.CreatureVulnerableDescriptionImpl
import com.example.witcherbestiary.vulnerable.view.description.CreatureVulnerableViewDescriptionImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DescriptionGraphModule {
    @Singleton
    @Provides
    fun provideDescriptionGraph(): DescriptionGraph<BestiaryRootDescription> {
        return DescriptionGraphImpl(
                "graph",
                BestiaryRootDescriptionImpl("bestiary_root",
                        BestiaryRootViewDescriptionImpl("bestiary_root_view"),
                        BestiaryMainDescriptionImpl(
                                "bestiary_main",
                                BestiaryMainViewDescriptionImpl("bestiary_main_view", Color(0xFF212121)),
                                HeaderDescriptionImpl(
                                        "main_header",
                                        "BESTIARY",
                                        HeaderViewDescriptionImpl(
                                                "main_header_view",
                                                Color(0xFF212121),
                                                Color.White,
                                                false,
                                                false,
                                                70,
                                                70
                                        )
                                ),
                                ListDescriptionImpl(
                                        "main_list",
                                        CreatureListViewDescriptionImpl("main_list_view"),
                                        CardDescriptionImpl(
                                                "card_creature",
                                                CardViewDescriptionImpl(
                                                        "card_creature_view",
                                                        3,
                                                        58,
                                                        0f to Color(0xFF3E2723),
                                                        0.3f to Color.DarkGray,
                                                        0f,
                                                        2,
                                                        Color.Black,
                                                        5,
                                                        4,
                                                        5,
                                                        -3,
                                                        Color(0xFFE0E0E0),
                                                        16,
                                                        1
                                                )
                                        )
                                )
                        ),
                        BestiaryDetailsDescriptionImpl(
                                "bestiary_details",
                                BestiaryDetailsViewDescriptionImpl("bestiary_details_view", Color.DarkGray),
                                HeaderDescriptionImpl("details_header", "DETAILS",
                                        HeaderViewDescriptionImpl(
                                                "details_header_view",
                                                Color(0xFF212121),
                                                Color.White,
                                                true,
                                                false,
                                                70,
                                                70
                                        )
                                ),
                                CarouselDescriptionImpl(
                                        "carousel",
                                        CarouselViewDescriptionImpl("carousel_view", 150, 150, 0.5f),
                                        CarouselSlotDescriptionImpl(
                                                "carousel_slot",
                                                CarouselSlotViewDescriptionImpl("carousel_slot_view", 150)
                                        )
                                ),
                                InfoDescriptionImpl(
                                        "info",
                                        InfoViewDescriptionImpl("info_view"),
                                        TabRowDescriptionImpl(
                                                "tab_row",
                                                listOf("About", "Weakness", "Location"),
                                                0,
                                                TabRowViewDescriptionImpl(
                                                        "tab_row_view",
                                                        Color(0xFF212121),
                                                        Color(0xFFE0E0E0),
                                                        14,
                                                        1
                                                )
                                        ),
                                        InfoSlotsDescriptionImpl(
                                                "info_slots",
                                                InfoSlotsViewDescriptionImpl("info_slots"),
                                                listOf(
                                                        InfoSlotDescriptionImpl(
                                                                "description_info_slot",
                                                                "about",
                                                                InfoSlotViewDescriptionImpl("description_info_slot_view", "about"),
                                                                TextDescriptionImpl(
                                                                        "creature_text",
                                                                        "",
                                                                        TextViewDescriptionImpl(
                                                                                "creature_text_view",
                                                                                Color(0xFFE0E0E0),
                                                                                TextAlign.Left,
                                                                                5
                                                                        )
                                                                ),
                                                        ),
                                                        InfoSlotDescriptionImpl(
                                                                "vulnerable_info_slot",
                                                                "vulnerable",
                                                                InfoSlotViewDescriptionImpl("vulnerable_info_slot_view", "vulnerable"),
                                                                CreatureVulnerableDescriptionImpl("creature_vulnerable",
                                                                        CreatureVulnerableViewDescriptionImpl(
                                                                                "vulnerable",
                                                                                Color(0xFFE0E0E0),
                                                                                TextAlign.Center,
                                                                                5
                                                                        )
                                                                ),
                                                        ),
                                                        InfoSlotDescriptionImpl(
                                                                "location_info_slot",
                                                                "location",
                                                                InfoSlotViewDescriptionImpl("location_info_slot_view", "location"),
                                                                CreatureLocationDescriptionImpl(
                                                                        "creature_location",
                                                                        CreatureLocationViewDescriptionImpl(
                                                                                "location",
                                                                                5,
                                                                                Color(0xFFE0E0E0),
                                                                                Color(0xFFE0E0E0),
                                                                        )
                                                                ),
                                                        )
                                                )
                                        )
                                )
                        ),
                        initialComponent = "bestiary_main"
                ),
                "witcher_bestiary.db"
        )
    }
}