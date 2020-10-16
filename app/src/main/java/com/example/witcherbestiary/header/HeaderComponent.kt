package com.example.witcherbestiary.header

import com.example.bloc.component.Component
import com.example.witcherbestiary.header.description.HeaderDescription
import com.example.witcherbestiary.header.view.HeaderView
import com.example.witcherbestiary.header.view.description.HeaderViewDescription

interface HeaderComponent : Component<HeaderViewDescription, HeaderDescription, HeaderView> {
    interface ViewEvents {
        fun back()
        fun forward()
    }

    sealed class Input {
        data class SetText(val text: String) : Input()
    }
    sealed class Output {
        object Back : Output()
        object Forward : Output()
    }
}