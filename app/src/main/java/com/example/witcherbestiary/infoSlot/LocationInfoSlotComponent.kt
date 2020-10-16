package com.example.witcherbestiary.infoSlot

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.ComponentBase
import com.example.bloc.store.EmptyStore
import com.example.bloc.view.View
import com.example.witcherbestiary.infoSlot.description.InfoSlotDescription
import com.example.witcherbestiary.infoSlot.initialValue.InfoSlotInitialValue
import com.example.witcherbestiary.infoSlot.initialValue.InfoSlotInitialValueImpl
import com.example.witcherbestiary.infoSlot.view.InfoSlotView
import com.example.witcherbestiary.infoSlot.view.description.InfoSlotViewDescription
import com.example.witcherbestiary.location.CreatureLocationComponent
import com.example.witcherbestiary.location.description.CreatureLocationDescription
import com.example.witcherbestiary.location.di.CreatureLocationAssembler
import com.example.witcherbestiary.location.initialValue.LocationInitialValue
import com.example.witcherbestiary.location.initialValue.LocationInitialValueImpl
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.infoSlot.InfoSlotComponent.Input as Input
import com.example.witcherbestiary.infoSlot.InfoSlotComponent.Output as Output
import com.example.witcherbestiary.location.CreatureLocationComponent.Input as ChildInput
import com.example.witcherbestiary.location.CreatureLocationComponent.Output as ChildOutput

internal class LocationInfoSlotComponent @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    description: InfoSlotDescription,
    val lifecycle: Lifecycle,
    initialValue: InfoSlotInitialValue,
    view: InfoSlotView,
    locationFactory: CreatureLocationAssembler.Factory
) : ComponentBase<InfoSlotViewDescription, InfoSlotDescription, InfoSlotView, EmptyStore>(description, EmptyStore(initialValue), view),
        InfoSlotComponent,
        InfoSlotComponent.ViewEvents
{
    private val childInput = BroadcastChannel<ChildInput>(Channel.BUFFERED)
    private val childOutput = BroadcastChannel<ChildOutput>(Channel.BUFFERED)
    private val child: CreatureLocationComponent = locationFactory
            .create(childInput.openSubscription(), childOutput, description.child as CreatureLocationDescription,
                    lifecycle, (initialValue.child?:LocationInitialValueImpl(initialValue.item!!)) as LocationInitialValue)
            .createComponent()
    override val childView: View<*> = child.view

    override fun init() {
        super.init()

        addChild(child)

        scope.launch {
            input.consumeAsFlow().collect {
                when(it) {
                    is Input.SetItem -> {
                        childInput.send(ChildInput.SetItem(it.item))
                    }
                }
            }
        }
    }

    override fun getParcel(): Parcelable {
        return InfoSlotInitialValueImpl(
                null,
                child.getParcel() as LocationInitialValue
        )
    }
}