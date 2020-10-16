package com.example.witcherbestiary.infoSlots.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.infoSlots.InfoSlotsComponent
import com.example.witcherbestiary.infoSlots.description.InfoSlotsDescription
import com.example.witcherbestiary.infoSlots.initialValue.InfoSlotsInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        InfoSlotsModule::class
    ]
)
interface InfoSlotsAssembler : ComponentAssembler<InfoSlotsDescription, InfoSlotsComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<InfoSlotsComponent.Input>,
            @BindsInstance output: SendChannel<InfoSlotsComponent.Output>,
            @BindsInstance description: InfoSlotsDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: InfoSlotsInitialValue
        ): InfoSlotsAssembler
    }
}