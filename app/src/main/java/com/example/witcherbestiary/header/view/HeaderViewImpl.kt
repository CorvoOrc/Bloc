package com.example.witcherbestiary.header.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.header.HeaderComponent
import com.example.witcherbestiary.header.store.HeaderStore
import com.example.witcherbestiary.header.view.description.HeaderViewDescription
import javax.inject.Inject

internal class HeaderViewImpl @Inject constructor() : ViewBase<HeaderViewDescription, HeaderStore.State, HeaderComponent.ViewEvents>(), HeaderView {
    @Composable
    override fun render() {
        val state = state.collectAsState()

        val text = state.value.text.toUpperCase()
        TopAppBar(
                title = {
                    Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = AnnotatedString(
                                    text = text,
                                    paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center)
                            )
                    )
                },
                navigationIcon = {
                    if (description.backIsActive) {
                        IconButton(onClick = { events?.back() }) {
                            Icon(Icons.Default.ArrowBack)
                        }
                    } else {
                        Spacer(modifier = Modifier.fillMaxHeight().width(description.navigationWidth.dp))
                    }
                },
                actions = {
                    if (description.forwardIsActive) {
                        IconButton(onClick = { events?.forward() }) {
                            Icon(Icons.Default.ArrowForward)
                        }
                    } else {
                        Spacer(modifier = Modifier.fillMaxHeight().width(description.actionWidth.dp))
                    }
                },
                backgroundColor = description.backgroundColor,
                contentColor = description.contentColor
        )
    }
}