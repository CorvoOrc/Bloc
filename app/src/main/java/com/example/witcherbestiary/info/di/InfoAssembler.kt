package com.example.witcherbestiary.info.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.info.InfoComponent
import com.example.witcherbestiary.info.description.InfoDescription
import com.example.witcherbestiary.info.initialValue.InfoInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        InfoModule::class
    ]
)
interface InfoAssembler : ComponentAssembler<InfoDescription, InfoComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<InfoComponent.Input>,
            @BindsInstance output: SendChannel<InfoComponent.Output>,
            @BindsInstance description: InfoDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: InfoInitialValue
        ): InfoAssembler
    }
}