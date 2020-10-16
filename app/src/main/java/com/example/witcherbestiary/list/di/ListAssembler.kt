package com.example.witcherbestiary.list.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.list.CreatureListComponent
import com.example.witcherbestiary.list.description.ListDescription
import com.example.witcherbestiary.list.initialValue.CreatureListInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        ListModule::class
    ]
)
interface ListAssembler : ComponentAssembler<ListDescription, CreatureListComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<CreatureListComponent.Input>,
            @BindsInstance output: SendChannel<CreatureListComponent.Output>,
            @BindsInstance description: ListDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: CreatureListInitialValue
        ): ListAssembler
    }
}