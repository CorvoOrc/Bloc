package com.example.witcherbestiary.carousel.di

import androidx.lifecycle.Lifecycle
import com.example.witcherbestiary.carousel.CarouselComponent
import com.example.witcherbestiary.carousel.description.CarouselDescription
import com.example.witcherbestiary.carousel.initialValue.CarouselInitialValue
import com.example.bloc.di.ComponentAssembler
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        CarouselModule::class
    ]
)
interface CarouselAssembler : ComponentAssembler<CarouselDescription, CarouselComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<CarouselComponent.Input>,
            @BindsInstance output: SendChannel<CarouselComponent.Output>,
            @BindsInstance description: CarouselDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: CarouselInitialValue
        ): CarouselAssembler
    }
}