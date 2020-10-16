package com.example.witcherbestiary.location

import com.example.bloc.component.Component
import com.example.witcherbestiary.location.description.CreatureLocationDescription
import com.example.witcherbestiary.location.view.CreatureLocationView
import com.example.witcherbestiary.location.view.description.CreatureLocationViewDescription
import com.example.witcherbestiary.model.Creature

interface CreatureLocationComponent : Component<CreatureLocationViewDescription, CreatureLocationDescription, CreatureLocationView> {
    sealed class Input {
        data class SetItem(val item: Creature) : Input()
    }
    sealed class Output
}