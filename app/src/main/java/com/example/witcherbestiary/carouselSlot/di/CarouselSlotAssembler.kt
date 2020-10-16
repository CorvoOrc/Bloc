package com.example.witcherbestiary.carouselSlot.di

import androidx.lifecycle.Lifecycle
import com.example.witcherbestiary.carouselSlot.CarouselSlotComponent
import com.example.witcherbestiary.carouselSlot.description.CarouselSlotDescription
import com.example.witcherbestiary.carouselSlot.initialValue.CarouselSlotInitialValue
import com.example.bloc.di.ComponentAssembler
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        CarouselSlotModule::class
    ]
)
interface CarouselSlotAssembler : ComponentAssembler<CarouselSlotDescription, CarouselSlotComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<CarouselSlotComponent.Input>,
            @BindsInstance output: SendChannel<CarouselSlotComponent.Output>,
            @BindsInstance description: CarouselSlotDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: CarouselSlotInitialValue
        ): CarouselSlotAssembler
    }
}