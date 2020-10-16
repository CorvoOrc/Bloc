package com.example.witcherbestiary.vulnerable.view

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.vulnerable.store.CreatureVulnerablesStore
import com.example.witcherbestiary.vulnerable.view.description.CreatureVulnerableViewDescription
import javax.inject.Inject

internal class CreatureVulnerableViewImpl @Inject constructor() : ViewBase<CreatureVulnerableViewDescription, CreatureVulnerablesStore.State, Any>(),
        CreatureVulnerableView
{
    @Composable
    override fun render() {
        val state = state.collectAsState()

        val result = ""
        Text(
            state.value.vulnerables.foldIndexed(result,
                { index, result, it ->
                    if (index == state.value.vulnerables.size - 1)
                        result.plus(it.name)
                    else
                        result.plus(it.name + ", ")
                }
            ),
            color = description.textColor,
            textAlign = description.textAlign,
            modifier = Modifier.fillMaxSize().padding(description.padding.dp))
    }
}