package com.example.witcherbestiary.text

import com.example.bloc.component.Component
import com.example.witcherbestiary.text.description.TextDescription
import com.example.witcherbestiary.text.view.TextView
import com.example.witcherbestiary.text.view.description.TextViewDescription

interface TextComponent : Component<TextViewDescription, TextDescription, TextView> {
    sealed class Input {
        data class Set(val text: String) : Input()
    }
    sealed class Output
}