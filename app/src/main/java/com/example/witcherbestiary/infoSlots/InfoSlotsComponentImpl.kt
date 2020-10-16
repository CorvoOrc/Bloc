package com.example.witcherbestiary.infoSlots

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.CollectionComponentBase
import com.example.witcherbestiary.infoSlot.InfoSlotComponent
import com.example.witcherbestiary.infoSlot.description.InfoSlotDescription
import com.example.witcherbestiary.infoSlot.di.InfoSlotAssembler
import com.example.witcherbestiary.infoSlot.initialValue.InfoSlotInitialValue
import com.example.witcherbestiary.infoSlot.initialValue.InfoSlotInitialValueImpl
import com.example.witcherbestiary.infoSlot.view.InfoSlotView
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription
import com.example.witcherbestiary.infoSlots.description.InfoSlotsDescription
import com.example.witcherbestiary.infoSlots.initialValue.InfoSlotsInitialValue
import com.example.witcherbestiary.infoSlots.initialValue.InfoSlotsInitialValueImpl
import com.example.witcherbestiary.infoSlots.store.InfoSlotsStore
import com.example.witcherbestiary.infoSlots.view.InfoSlotsView
import com.example.witcherbestiary.infoSlots.view.description.InfoSlotsViewDescription
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.infoSlots.InfoSlotsComponent.Input as Input
import com.example.witcherbestiary.infoSlots.InfoSlotsComponent.Output as Output
import com.example.witcherbestiary.infoSlots.store.InfoSlotsStore.Intent as Intent
import com.example.witcherbestiary.infoSlot.InfoSlotComponent.Input as SlotInput
import com.example.witcherbestiary.infoSlot.InfoSlotComponent.Output as SlotOutput

internal class InfoSlotsComponentImpl @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    description: InfoSlotsDescription,
    val lifecycle: Lifecycle,
    val initialValue: InfoSlotsInitialValue,
    store: InfoSlotsStore,
    view: InfoSlotsView,
    val infoSlotFactory: InfoSlotAssembler.Factory
) : CollectionComponentBase<InfoSlotViewDescription, InfoSlotDescription, InfoSlotView, InfoSlotComponent, InfoSlotsViewDescription, InfoSlotsDescription, InfoSlotsView, InfoSlotsStore>(description, store, view),
        InfoSlotsComponent,
        InfoSlotsComponent.ViewEvents {
    private val itemInputs = mutableListOf<BroadcastChannel<SlotInput>>()

    override var itemsView: List<InfoSlotView> = description.items.mapIndexed { index, infoSlotDescription ->
        val infoSlotInput = BroadcastChannel<SlotInput>(Channel.BUFFERED)
        itemInputs.add(infoSlotInput)
        val infoSlotOutput = BroadcastChannel<SlotOutput>(Channel.BUFFERED)
        val infoSlotComponent = infoSlotFactory
                .create(infoSlotInput.openSubscription(),
                        infoSlotOutput,
                        infoSlotDescription,
                        lifecycle,
                        (if (initialValue.list.size > index) initialValue.list[index] else InfoSlotInitialValueImpl())
                                .apply { item = initialValue.item!! })
                .createComponent()
        add(infoSlotComponent)
        infoSlotComponent.init()
        infoSlotComponent.view
    }

    override fun init() {
        super.init()

        scope.launch {
            input.consumeAsFlow().collect {
                when (it) {
                    is Input.SetItem -> itemInputs.forEach { item -> item.send(SlotInput.SetItem(it.item)) }
                    is Input.SetIndex -> store.execute(Intent.Set(it.index))
                }
            }
        }
    }

    override fun getParcel(): Parcelable {
        return InfoSlotsInitialValueImpl(
            null,
            store.state.value.index,
            items.map { it.getParcel() as InfoSlotInitialValue }
        )
    }
}