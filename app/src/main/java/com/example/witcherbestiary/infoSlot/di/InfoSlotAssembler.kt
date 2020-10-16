package com.example.witcherbestiary.infoSlot.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.FactoryComponentAssembler
import com.example.witcherbestiary.infoSlot.InfoSlotComponent
import com.example.witcherbestiary.infoSlot.description.InfoSlotDescription
import com.example.witcherbestiary.infoSlot.di.factory.InfoSlotFactory
import com.example.witcherbestiary.infoSlot.initialValue.InfoSlotInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
        modules = [
            InfoSlotModule::class,
            InfoSlotViewModule::class,
            InfoSlotViewProvideModule::class
        ]
)
abstract class InfoSlotAssembler : FactoryComponentAssembler<InfoSlotDescription, InfoSlotComponent, InfoSlotFactory> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<InfoSlotComponent.Input>,
            @BindsInstance output: SendChannel<InfoSlotComponent.Output>,
            @BindsInstance description: InfoSlotDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: InfoSlotInitialValue
        ): InfoSlotAssembler
    }
}