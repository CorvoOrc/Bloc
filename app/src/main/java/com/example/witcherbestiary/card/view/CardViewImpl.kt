package com.example.witcherbestiary.card.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.graphics.HorizontalGradient
import androidx.compose.ui.platform.DensityAmbient
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.witcherbestiary.card.CardComponent
import com.example.witcherbestiary.card.store.CardStore
import com.example.witcherbestiary.card.view.description.CardViewDescription
import com.example.bloc.view.ViewBase
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.ui.NetworkImage
import javax.inject.Inject

internal class CardViewImpl @Inject constructor() :
        ViewBase<CardViewDescription, CardStore.State, CardComponent.ViewEvents>(),
        CardView
{
    @Composable
    override fun render() {
        val state = state.collectAsState()

        val eve = events
        Row(
                modifier = Modifier.clickable(onClick = {
                    events?.select(state.value.item)
                }
                )
                        .padding(description.padding.dp),
                horizontalArrangement = Arrangement.Center
        ) {
            WithConstraints {
                val boxWidth = with(DensityAmbient.current) { constraints.maxWidth.toDp() }
                val boxHeight = description.height.dp
                val cardModifier = Modifier
                        .preferredSize(boxWidth, boxHeight)
                        .background(
                                HorizontalGradient(
                                        description.colorStopA,
                                        description.colorStopB,
                                        startX = description.startX,
                                        endX = boxWidth.value
                                )
                        )
                cardContent(item = state.value.item, modifier = cardModifier)
            }
        }
    }

    @Composable
    private fun cardContent(item: Creature, modifier: Modifier) {
        Box(
                modifier = modifier.border(
                    BorderStroke(description.borderWidth.dp, description.borderColor),
                    RoundedCornerShape(description.borderShape.dp)
                ),
            alignment = CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                NetworkImage(item.previewUrl, Modifier.padding(description.imagePadding.dp))
                Text(
                        text = AnnotatedString(
                                item.name,
                                paragraphStyle = ParagraphStyle(textAlign = TextAlign.Left)
                        ),
                        modifier = Modifier.offset(description.textOffsetX.dp, description.textOffsetY.dp),
                        color = description.textColor,
                        fontSize = description.fontSize.sp,
                        maxLines = description.maxTextLines
                )
            }
        }
    }
}