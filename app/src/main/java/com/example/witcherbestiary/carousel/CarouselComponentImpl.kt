package com.example.witcherbestiary.carousel

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.witcherbestiary.carousel.description.CarouselDescription
import com.example.witcherbestiary.carousel.initialValue.CarouselInitialValue
import com.example.witcherbestiary.carousel.initialValue.CarouselInitialValueImpl
import com.example.witcherbestiary.carousel.store.CarouselStore
import com.example.witcherbestiary.carousel.view.CarouselView
import com.example.witcherbestiary.carousel.view.description.CarouselViewDescription
import com.example.witcherbestiary.carouselSlot.CarouselSlotComponent
import com.example.witcherbestiary.carouselSlot.description.CarouselSlotDescription
import com.example.witcherbestiary.carouselSlot.di.CarouselSlotAssembler
import com.example.witcherbestiary.carouselSlot.initialValue.CarouselSlotInitialValueImpl
import com.example.witcherbestiary.carouselSlot.view.CarouselSlotView
import com.example.witcherbestiary.carouselSlot.view.description.CarouselSlotViewDescription
import com.example.bloc.component.CollectionComponentBase
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.carousel.CarouselComponent.Input as Input
import com.example.witcherbestiary.carousel.CarouselComponent.Output as Output
import com.example.witcherbestiary.carousel.store.CarouselStore.Intent as Intent
import com.example.witcherbestiary.carouselSlot.CarouselSlotComponent.Input as SlotInput
import com.example.witcherbestiary.carouselSlot.CarouselSlotComponent.Output as SlotOutput

internal class CarouselComponentImpl @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    description: CarouselDescription,
    val lifecycle: Lifecycle,
    initialValue: CarouselInitialValue,
    store: CarouselStore,
    view: CarouselView,
    private val slotFactory: CarouselSlotAssembler.Factory
) : CollectionComponentBase<CarouselSlotViewDescription, CarouselSlotDescription, CarouselSlotView, CarouselSlotComponent, CarouselViewDescription, CarouselDescription, CarouselView, CarouselStore>(description, store, view),
        CarouselComponent,
        CarouselComponent.ViewEvents {
    override fun init() {
        super.init()

        scope.launch {
            input.consumeAsFlow().collect {
                when (it) {
                    is Input.SetSelection -> {
                        store.execute(Intent.SetSelection(it.item))
                    }
                }
            }
        }

        scope.launch {
            store.labelChannel.consumeAsFlow().collect {
                when(it) {
                    is CarouselStore.Label.Updated -> output.send(Output.Updated(it.item))
                }
            }
        }
    }

    override fun prepareCreatingItems() {
        clear()
    }

    override fun createItem(item: Creature): CarouselSlotView {
        val slotInput = BroadcastChannel<SlotInput>(Channel.BUFFERED)
        val slotOutput = BroadcastChannel<SlotOutput>(Channel.BUFFERED)
        val slotComponent = slotFactory
                .create(slotInput.openSubscription(), slotOutput, description.slot, lifecycle, CarouselSlotInitialValueImpl(item))
                .createComponent()
        add(slotComponent)
        slotComponent.init()
        return slotComponent.view
    }

    override fun changePage(prevPage: Int, newPage: Int, currentItem: Creature) {
        scope.launch {
            store.execute(Intent.SetSelection(currentItem))
            output.send(Output.Changed(prevPage, newPage, currentItem))
        }
    }

    override fun getParcel(): Parcelable {
        val state = store.state.value
        return CarouselInitialValueImpl(
                state.selection!!,
                state.items.map {CarouselSlotInitialValueImpl(it)},
                state.prev,
                state.current
        )
    }
}