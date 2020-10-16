package com.example.witcherbestiary.card

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.witcherbestiary.card.description.CardDescription
import com.example.witcherbestiary.card.initialValue.CardInitialValue
import com.example.witcherbestiary.card.initialValue.CardInitialValueImpl
import com.example.witcherbestiary.card.store.CardStore
import com.example.witcherbestiary.card.view.CardView
import com.example.witcherbestiary.card.view.description.CardViewDescription
import com.example.bloc.component.ComponentBase
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.card.CardComponent.Input as Input
import com.example.witcherbestiary.card.CardComponent.Output as Output

internal class CardComponentImpl @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    val lifecycle: Lifecycle,
    description: CardDescription,
    initialValue: CardInitialValue,
    store: CardStore,
    view: CardView
) : ComponentBase<CardViewDescription, CardDescription, CardView, CardStore>(description, store, view), CardComponent, CardComponent.ViewEvents {
    override fun select(item: Creature) {
        scope.launch {
            output.send(Output.Selected(item))
        }
    }

    override fun getParcel(): Parcelable {
        return CardInitialValueImpl(store.state.value.item)
    }
}