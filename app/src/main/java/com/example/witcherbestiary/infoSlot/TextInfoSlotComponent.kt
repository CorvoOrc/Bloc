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
import com.example.witcherbestiary.text.TextComponent
import com.example.witcherbestiary.text.description.TextDescription
import com.example.witcherbestiary.text.di.TextAssembler
import com.example.witcherbestiary.text.initialValue.TextInitialValue
import com.example.witcherbestiary.text.initialValue.TextInitialValueImpl
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
import com.example.witcherbestiary.text.TextComponent.Input as ChildInput
import com.example.witcherbestiary.text.TextComponent.Output as ChildOutput

internal class TextInfoSlotComponent @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    override val description: InfoSlotDescription,
    val lifecycle: Lifecycle,
    initialValue: InfoSlotInitialValue,
    override val view: InfoSlotView,
    textFactory: TextAssembler.Factory
) : ComponentBase<InfoSlotViewDescription, InfoSlotDescription, InfoSlotView, EmptyStore>(description, EmptyStore(initialValue), view),
        InfoSlotComponent,
        InfoSlotComponent.ViewEvents
{
    private val childInput = BroadcastChannel<ChildInput>(Channel.BUFFERED)
    private val childOutput = BroadcastChannel<ChildOutput>(Channel.BUFFERED)
    private val child: TextComponent = textFactory
            .create(childInput.openSubscription(), childOutput, description.child as TextDescription,
                    lifecycle, (initialValue.child?:TextInitialValueImpl(initialValue.item!!.description)) as TextInitialValue)
            .createComponent()
    override val childView: View<*> = child.view

    override fun init() {
        super.init()

        addChild(child)

        scope.launch {
            input.consumeAsFlow().collect {
                when(it) {
                    is Input.SetItem -> childInput.send(ChildInput.Set(it.item.description))
                }
            }
        }
    }

    override fun getParcel(): Parcelable {
        return InfoSlotInitialValueImpl(
                null,
                child.getParcel() as TextInitialValue
        )
    }
}