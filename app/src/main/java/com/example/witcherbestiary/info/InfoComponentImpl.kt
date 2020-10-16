package com.example.witcherbestiary.info

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.ComponentBase
import com.example.witcherbestiary.info.description.InfoDescription
import com.example.witcherbestiary.info.initialValue.InfoInitialValue
import com.example.witcherbestiary.info.initialValue.InfoInitialValueImpl
import com.example.witcherbestiary.info.store.InfoStore
import com.example.witcherbestiary.info.view.InfoView
import com.example.witcherbestiary.info.view.description.InfoViewDescription
import com.example.witcherbestiary.infoSlots.di.InfoSlotsAssembler
import com.example.witcherbestiary.infoSlots.initialValue.InfoSlotsInitialValue
import com.example.witcherbestiary.infoSlots.initialValue.InfoSlotsInitialValueImpl
import com.example.witcherbestiary.infoSlots.view.InfoSlotsView
import com.example.witcherbestiary.tab.di.TabRowAssembler
import com.example.witcherbestiary.tab.initialValue.TabRowInitialValue
import com.example.witcherbestiary.tab.initialValue.TabRowInitialValueImpl
import com.example.witcherbestiary.tab.view.TabRowView
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.info.InfoComponent.Input as Input
import com.example.witcherbestiary.info.InfoComponent.Output as Output
import com.example.witcherbestiary.infoSlots.InfoSlotsComponent.Input as SlotsInput
import com.example.witcherbestiary.infoSlots.InfoSlotsComponent.Output as SlotsOutput
import com.example.witcherbestiary.tab.TabRowComponent.Input as TabRowInput
import com.example.witcherbestiary.tab.TabRowComponent.Output as TabRowOutput

internal class InfoComponentImpl @Inject constructor(
        val input: ReceiveChannel<Input>,
        private val output: SendChannel<Output>,
        description: InfoDescription,
        val lifecycle: Lifecycle,
        initialValue: InfoInitialValue,
        store: InfoStore,
        view: InfoView,
        tabRowFactory: TabRowAssembler.Factory,
        infoSlotsFactory: InfoSlotsAssembler.Factory
) : ComponentBase<InfoViewDescription, InfoDescription, InfoView, InfoStore>(description, store, view),
        InfoComponent,
        InfoComponent.ViewEvents {
    private val infoSlotsInput = BroadcastChannel<SlotsInput>(Channel.BUFFERED)
    private val infoSlotsOutput = BroadcastChannel<SlotsOutput>(Channel.BUFFERED)
    private val infoSlotsComponent = infoSlotsFactory.create(infoSlotsInput.openSubscription(), infoSlotsOutput, description.slots,
            lifecycle, (initialValue.infoSlots?:InfoSlotsInitialValueImpl()).apply { item = initialValue.item })
            .createComponent()
    override val infoSlotsView: InfoSlotsView = infoSlotsComponent.view

    private val tabInput = BroadcastChannel<TabRowInput>(Channel.BUFFERED)
    private val tabOutput = BroadcastChannel<TabRowOutput>(Channel.BUFFERED)
    private val tabComponent = tabRowFactory
            .create(tabInput.openSubscription(), tabOutput, description.tabRow, lifecycle, initialValue.tabRow?:TabRowInitialValueImpl())
            .createComponent()
    override val tabView: TabRowView = tabComponent.view

    override fun init() {
        super.init()

        addChild(infoSlotsComponent)
        addChild(tabComponent)

        scope.launch {
            input.consumeAsFlow().collect {
                when(it) {
                    is Input.SetItem -> infoSlotsInput.send(SlotsInput.SetItem(it.item))
                }
            }
        }

        scope.launch {
            tabOutput.asFlow().collect {
                when(it) {
                    is TabRowOutput.Selected -> infoSlotsInput.send(SlotsInput.SetIndex(it.index))
                }
            }
        }
    }

    override fun getParcel(): Parcelable {
        return InfoInitialValueImpl(
                store.state.value.item,
                infoSlotsComponent.getParcel() as InfoSlotsInitialValue,
                tabComponent.getParcel() as TabRowInitialValue
        )
    }
}