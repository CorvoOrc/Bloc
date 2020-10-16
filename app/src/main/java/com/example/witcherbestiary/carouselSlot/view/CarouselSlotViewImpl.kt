package com.example.witcherbestiary.carouselSlot.view

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.witcherbestiary.carouselSlot.store.CarouselSlotStore
import com.example.witcherbestiary.carouselSlot.view.description.CarouselSlotViewDescription
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.ui.NetworkImage
import javax.inject.Inject

internal class CarouselSlotViewImpl @Inject constructor() : ViewBase<CarouselSlotViewDescription, CarouselSlotStore.State, Any>(),
        CarouselSlotView {
    @Composable
    override fun render() {
        val state = state.collectAsState()
        NetworkImage(state.value.item.imgUrl, Modifier.height(description.height.dp))
    }
}