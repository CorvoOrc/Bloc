package com.example.witcherbestiary.location.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.location.CreatureLocationComponent
import com.example.witcherbestiary.location.description.CreatureLocationDescription
import com.example.witcherbestiary.location.initialValue.LocationInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        CreatureLocationModule::class
    ]
)
interface CreatureLocationAssembler : ComponentAssembler<CreatureLocationDescription, CreatureLocationComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<CreatureLocationComponent.Input>,
            @BindsInstance output: SendChannel<CreatureLocationComponent.Output>,
            @BindsInstance description: CreatureLocationDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: LocationInitialValue
        ): CreatureLocationAssembler
    }
}