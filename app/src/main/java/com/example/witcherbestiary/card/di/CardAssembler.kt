package com.example.witcherbestiary.card.di

import androidx.lifecycle.Lifecycle
import com.example.witcherbestiary.card.CardComponent
import com.example.witcherbestiary.card.description.CardDescription
import com.example.witcherbestiary.card.initialValue.CardInitialValue
import com.example.bloc.di.ComponentAssembler
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        CardModule::class
    ]
)
interface CardAssembler : ComponentAssembler<CardDescription, CardComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<CardComponent.Input>,
            @BindsInstance output: SendChannel<CardComponent.Output>,
            @BindsInstance description: CardDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: CardInitialValue
        ): CardAssembler
    }
}