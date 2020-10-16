package com.example.witcherbestiary.text.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.text.TextComponent
import com.example.witcherbestiary.text.description.TextDescription
import com.example.witcherbestiary.text.initialValue.TextInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        TextModule::class
    ]
)
interface TextAssembler : ComponentAssembler<TextDescription, TextComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<TextComponent.Input>,
            @BindsInstance output: SendChannel<TextComponent.Output>,
            @BindsInstance description: TextDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: TextInitialValue
        ): TextAssembler
    }
}