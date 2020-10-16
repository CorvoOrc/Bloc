package com.example.witcherbestiary.text.description

import com.example.witcherbestiary.text.view.description.TextViewDescription

data class TextDescriptionImpl(
        override val id: String,
        override val initial: String,
        override val view: TextViewDescription
) : TextDescription