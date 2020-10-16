package com.example.witcherbestiary.text.view

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.text.store.TextStore
import com.example.witcherbestiary.text.view.description.TextViewDescription
import javax.inject.Inject

internal class TextViewImpl @Inject constructor() : ViewBase<TextViewDescription, TextStore.State, Any>(),
        TextView
{
    @Composable
    override fun render() {
        val state = state.collectAsState()

        ScrollableColumn(modifier = Modifier.fillMaxSize()) {
            Text(
                    text = state.value.text,
                    color = description.textColor,
                    textAlign = description.textAlign,
                    modifier = Modifier.padding(description.padding.dp)
            )
        }
    }
}