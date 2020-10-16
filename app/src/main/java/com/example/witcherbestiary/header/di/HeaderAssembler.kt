package com.example.witcherbestiary.header.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.header.HeaderComponent
import com.example.witcherbestiary.header.description.HeaderDescription
import com.example.witcherbestiary.header.initialValue.HeaderInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        HeaderModule::class
    ]
)
interface HeaderAssembler : ComponentAssembler<HeaderDescription, HeaderComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<HeaderComponent.Input>,
            @BindsInstance output: SendChannel<HeaderComponent.Output>,
            @BindsInstance description: HeaderDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: HeaderInitialValue
        ): HeaderAssembler
    }
}