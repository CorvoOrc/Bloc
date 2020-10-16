package com.example.witcherbestiary.text.description

import com.example.bloc.description.ComponentDescription
import com.example.witcherbestiary.text.view.description.TextViewDescription

interface TextDescription : ComponentDescription<TextViewDescription> {
    val initial: String
}