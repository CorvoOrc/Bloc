package com.example.witcherbestiary.vulnerable.description

import com.example.witcherbestiary.vulnerable.view.description.CreatureVulnerableViewDescription

data class CreatureVulnerableDescriptionImpl(
        override val id: String,
        override val view: CreatureVulnerableViewDescription
) : CreatureVulnerableDescription