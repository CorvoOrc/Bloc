package com.example.witcherbestiary.vulnerable.di

import androidx.lifecycle.Lifecycle
import com.example.bloc.di.ComponentAssembler
import com.example.witcherbestiary.vulnerable.CreatureVulnerableComponent
import com.example.witcherbestiary.vulnerable.description.CreatureVulnerableDescription
import com.example.witcherbestiary.vulnerable.initialValue.VulnerableInitialValue
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Subcomponent(
    modules = [
        CreatureVulnerableModule::class
    ]
)
interface CreatureVulnerableAssembler :
    ComponentAssembler<CreatureVulnerableDescription, CreatureVulnerableComponent> {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance input: ReceiveChannel<CreatureVulnerableComponent.Input>,
            @BindsInstance output: SendChannel<CreatureVulnerableComponent.Output>,
            @BindsInstance description: CreatureVulnerableDescription,
            @BindsInstance lifecycle: Lifecycle,
            @BindsInstance initialValue: VulnerableInitialValue
        ): CreatureVulnerableAssembler
    }
}