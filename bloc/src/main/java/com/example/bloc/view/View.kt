package com.example.bloc.view

import androidx.compose.runtime.Composable
import com.example.bloc.common.Destroyable
import com.example.bloc.description.ViewDescription
import kotlinx.coroutines.flow.StateFlow

interface View<TDescription : ViewDescription> : Destroyable {
    val description: TDescription

    fun init(description: TDescription, state: StateFlow<*>, events: Any?)

    @Composable
    fun render()
}