package com.example.witcherbestiary.root.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.root.BestiaryRootComponent
import com.example.bloc.value.RootInitialValue
import com.example.witcherbestiary.root.description.BestiaryRootDescription
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        RootModule::class
    ]
)
interface RootAssembler : ComponentAssembler<BestiaryRootDescription, BestiaryRootComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<BestiaryRootComponent.Input>,
            @BindsInstance output: SendChannel<BestiaryRootComponent.Output>,
            @BindsInstance description: BestiaryRootDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: RootInitialValue
        ): RootAssembler
    }
}