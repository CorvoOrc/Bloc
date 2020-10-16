package com.example.witcherbestiary.carouselSlot

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.witcherbestiary.carouselSlot.description.CarouselSlotDescription
import com.example.witcherbestiary.carouselSlot.initialValue.CarouselSlotInitialValue
import com.example.witcherbestiary.carouselSlot.initialValue.CarouselSlotInitialValueImpl
import com.example.witcherbestiary.carouselSlot.store.CarouselSlotStore
import com.example.witcherbestiary.carouselSlot.view.CarouselSlotView
import com.example.witcherbestiary.carouselSlot.view.description.CarouselSlotViewDescription
import com.example.bloc.component.ComponentBase
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.carouselSlot.CarouselSlotComponent.Input as Input
import com.example.witcherbestiary.carouselSlot.CarouselSlotComponent.Output as Output
import com.example.witcherbestiary.carouselSlot.store.CarouselSlotStore.Intent as Intent

internal class CarouselSlotComponentImpl @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    description: CarouselSlotDescription,
    val lifecycle: Lifecycle,
    initialValue: CarouselSlotInitialValue,
    store: CarouselSlotStore,
    view: CarouselSlotView
) : ComponentBase<CarouselSlotViewDescription, CarouselSlotDescription, CarouselSlotView, CarouselSlotStore>(description, store, view),
        CarouselSlotComponent {
    override fun init() {
        super.init()

        scope.launch {
            input.consumeAsFlow().collect {
                when (it) {
                    is Input.SetItem -> {
                        store.execute(Intent.SetItem(it.item))
                    }
                }
            }
        }
    }

    override fun getParcel(): Parcelable {
        return CarouselSlotInitialValueImpl(store.state.value.item)
    }
}