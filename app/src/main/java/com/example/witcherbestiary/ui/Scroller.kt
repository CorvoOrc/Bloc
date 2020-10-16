package com.example.witcherbestiary.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Layout
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@Composable
fun VisibleScroller(scrollState: ScrollState) {
    Column(horizontalAlignment = Alignment.End) {
        Layout(
                children = {
                    Box(
                        modifier = Modifier.height(70.dp).width(3.dp).offset(x = (-1.5).dp)
                            .background(Color.LightGray, RoundedCornerShape(5f)))
                }
        ) { measurables, constraints ->
            layout(constraints.maxWidth, constraints.maxHeight) {
                measurables.forEach {
                    val placeable = it.measure(constraints = constraints.copy())

                    val xCenterOffset = (constraints.maxWidth - placeable.width) / 2

                    placeable.place(
                            x = xCenterOffset,
                            y = (if(scrollState.maxValue == 0f) 0f else scrollState.value / scrollState.maxValue * (constraints.maxHeight - placeable.height)).roundToInt()
                    )
                }
            }
        }
    }
}