package com.example.witcherbestiary.vulnerable

import com.example.bloc.component.Component
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.vulnerable.description.CreatureVulnerableDescription
import com.example.witcherbestiary.vulnerable.view.CreatureVulnerableView
import com.example.witcherbestiary.vulnerable.view.description.CreatureVulnerableViewDescription

interface CreatureVulnerableComponent : Component<CreatureVulnerableViewDescription, CreatureVulnerableDescription, CreatureVulnerableView> {
    sealed class Input {
        data class SetItem(val item: Creature) : Input()
    }
    sealed class Output
}