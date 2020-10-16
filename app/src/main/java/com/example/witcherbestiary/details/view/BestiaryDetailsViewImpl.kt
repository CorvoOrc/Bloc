package com.example.witcherbestiary.details.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.witcherbestiary.carousel.view.CarouselView
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.details.BestiaryDetailsComponent
import com.example.witcherbestiary.details.view.description.BestiaryDetailsViewDescription
import com.example.witcherbestiary.header.view.HeaderView
import com.example.witcherbestiary.info.view.InfoView
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class BestiaryDetailsViewImpl @Inject constructor() : ViewBase<BestiaryDetailsViewDescription, Any, BestiaryDetailsComponent.ViewEvents>(),
        BestiaryDetailsView {
    lateinit var headerView: HeaderView
        private set
    lateinit var carouselView: CarouselView
        private set
    lateinit var infoView: InfoView
        private set

    override fun init(description: BestiaryDetailsViewDescription, state: StateFlow<*>, events: Any?) {
        super.init(description, state, events)

        headerView = this.events!!.headerView
        carouselView = this.events!!.carouselView
        infoView = this.events!!.infoView
    }

    @Composable
    override fun render() {
        Column {
            headerView.render()
            Column(
                modifier = Modifier.background(color = description.backgroundColor),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                carouselView.render()
                infoView.render()
            }
        }
    }
}