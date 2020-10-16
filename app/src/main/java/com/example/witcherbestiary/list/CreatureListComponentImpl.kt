package com.example.witcherbestiary.list

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.witcherbestiary.card.CardComponent
import com.example.witcherbestiary.card.description.CardDescription
import com.example.witcherbestiary.card.di.CardAssembler
import com.example.witcherbestiary.card.initialValue.CardInitialValue
import com.example.witcherbestiary.card.initialValue.CardInitialValueImpl
import com.example.witcherbestiary.card.view.CardView
import com.example.witcherbestiary.card.view.description.CardViewDescription
import com.example.bloc.component.CollectionComponentBase
import com.example.witcherbestiary.list.description.ListDescription
import com.example.witcherbestiary.list.initialValue.CreatureListInitialValue
import com.example.witcherbestiary.list.initialValue.CreatureListInitialValueImpl
import com.example.witcherbestiary.list.store.CreatureListStore
import com.example.witcherbestiary.list.view.CreatureListView
import com.example.witcherbestiary.list.view.description.CreatureListViewDescription
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.list.CreatureListComponent.Input as Input
import com.example.witcherbestiary.list.CreatureListComponent.Output as Output

internal class CreatureListComponentImpl @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    override val description: ListDescription,
    val lifecycle: Lifecycle,
    initialValue: CreatureListInitialValue,
    store: CreatureListStore,
    view: CreatureListView,
    private val creatureFactory: CardAssembler.Factory
) : CollectionComponentBase<CardViewDescription, CardDescription, CardView, CardComponent, CreatureListViewDescription, ListDescription, CreatureListView, CreatureListStore>(description, store, view),
        CreatureListComponent,
        CreatureListComponent.ViewEvents
{
    override fun prepareCreatingItems() {
        clear()
    }

    override fun createItem(item: Creature): CardView {
        val cardInput = BroadcastChannel<CardComponent.Input>(Channel.BUFFERED)
        val cardOutput = BroadcastChannel<CardComponent.Output>(Channel.BUFFERED)
        scope.launch {
            cardOutput.asFlow().collect {
                when (it) {
                    is CardComponent.Output.Selected -> {
                        output.send(Output.Selected(it.item))
                    }
                }
            }
        }
        val cardComponent = creatureFactory
                .create(cardInput.openSubscription(), cardOutput, description.creature, lifecycle, CardInitialValueImpl(item))
                .createComponent()
        cardComponent.init()
        add(cardComponent)
        return cardComponent.view
    }

    override fun getParcel(): Parcelable {
        return CreatureListInitialValueImpl(items.map { it.getParcel() as CardInitialValue })
    }
}