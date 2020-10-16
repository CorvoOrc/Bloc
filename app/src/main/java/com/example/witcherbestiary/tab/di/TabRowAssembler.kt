package com.example.witcherbestiary.tab.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.tab.TabRowComponent
import com.example.witcherbestiary.tab.description.TabRowDescription
import com.example.witcherbestiary.tab.initialValue.TabRowInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        TabRowModule::class
    ]
)
interface TabRowAssembler : ComponentAssembler<TabRowDescription, TabRowComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<TabRowComponent.Input>,
            @BindsInstance output: SendChannel<TabRowComponent.Output>,
            @BindsInstance description: TabRowDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: TabRowInitialValue
        ): TabRowAssembler
    }
}