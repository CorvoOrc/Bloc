package com.example.witcherbestiary.details.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.details.BestiaryDetailsComponent
import com.example.witcherbestiary.details.description.BestiaryDetailsDescription
import com.example.witcherbestiary.details.initialValue.DetailsInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        BestiaryDetailsModule::class
    ]
)
interface BestiaryDetailsAssembler : ComponentAssembler<BestiaryDetailsDescription, BestiaryDetailsComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
                @BindsInstance input: ReceiveChannel<BestiaryDetailsComponent.Input>,
                @BindsInstance output: SendChannel<BestiaryDetailsComponent.Output>,
                @BindsInstance description: BestiaryDetailsDescription,
                @BindsInstance lifecycle: Lifecycle,
                @BindsInstance initialValue: DetailsInitialValue
        ): BestiaryDetailsAssembler
    }
}