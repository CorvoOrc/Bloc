package com.example.witcherbestiary.main.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.main.BestiaryMainComponent
import com.example.witcherbestiary.main.description.BestiaryMainDescription
import com.example.witcherbestiary.main.initialValue.MainInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        BestiaryMainModule::class
    ]
)
interface BestiaryMainAssembler : ComponentAssembler<BestiaryMainDescription, BestiaryMainComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<BestiaryMainComponent.Input>,
            @BindsInstance output: SendChannel<BestiaryMainComponent.Output>,
            @BindsInstance description: BestiaryMainDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: MainInitialValue
        ): BestiaryMainAssembler
    }
}