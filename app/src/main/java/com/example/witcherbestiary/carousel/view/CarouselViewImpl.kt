package com.example.witcherbestiary.carousel.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AnimationClockAmbient
import androidx.compose.ui.unit.dp
import com.example.witcherbestiary.carousel.CarouselComponent
import com.example.witcherbestiary.carousel.store.CarouselStore
import com.example.witcherbestiary.carousel.view.description.CarouselViewDescription
import com.example.witcherbestiary.carouselSlot.view.CarouselSlotView
import com.example.witcherbestiary.carouselSlot.view.description.CarouselSlotViewDescription
import com.example.bloc.view.CollectionViewBase
import com.example.witcherbestiary.ui.Pager
import com.example.witcherbestiary.ui.PagerState
import javax.inject.Inject

internal class CarouselViewImpl @Inject constructor() : CollectionViewBase<CarouselViewDescription, CarouselSlotViewDescription, CarouselSlotView, CarouselStore.State, CarouselComponent.ViewEvents>(),
        CarouselView {
    @Composable
    override fun render() {
        val state = state.collectAsState()

        clear()
        events?.prepareCreatingItems()
        addAll(
                state.value.items.map {
                    events!!.createItem(it)
                }
        )
        if (items.isNotEmpty() && state.value.current != -1) {
            val clock = AnimationClockAmbient.current
            val pagerState = remember {
                PagerState(clock,
                    currentPage = state.value.current,
                    maxPage = (state.value.items.size - 1),
                    onChangePage = { prevPage, newPage ->
                        events?.changePage(prevPage, newPage, state.value.items[newPage])
                    }
                )
            }
            pagerState.currentPage = state.value.current
            pagerState.maxPage = state.value.items.size - 1
            Pager(pagerState, modifier = Modifier.height(description.pagerHeight.dp)) {
                Row(
                        modifier = Modifier.width(description.pagerRowWidth.dp).scalePagerItems(description.unselectedScale),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    items[page].render()
                }
            }
        }
    }
}