package com.example.witcherbestiary.main

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.ComponentBase
import com.example.witcherbestiary.header.HeaderComponent
import com.example.witcherbestiary.header.di.HeaderAssembler
import com.example.witcherbestiary.header.initialValue.HeaderInitialValue
import com.example.witcherbestiary.header.initialValue.HeaderInitialValueImpl
import com.example.witcherbestiary.header.view.HeaderView
import com.example.witcherbestiary.list.di.ListAssembler
import com.example.witcherbestiary.list.initialValue.CreatureListInitialValue
import com.example.witcherbestiary.list.initialValue.CreatureListInitialValueImpl
import com.example.witcherbestiary.list.view.CreatureListView
import com.example.witcherbestiary.main.description.BestiaryMainDescription
import com.example.witcherbestiary.main.initialValue.MainInitialValue
import com.example.witcherbestiary.main.initialValue.MainInitialValueImpl
import com.example.witcherbestiary.main.store.BestiaryMainStore
import com.example.witcherbestiary.main.view.BestiaryMainView
import com.example.witcherbestiary.main.view.description.BestiaryMainViewDescription
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.main.BestiaryMainComponent.Input as Input
import com.example.witcherbestiary.main.BestiaryMainComponent.Output as Output
import com.example.witcherbestiary.main.store.BestiaryMainStore.Intent as Intent
import com.example.witcherbestiary.list.CreatureListComponent.Input as ListInput
import com.example.witcherbestiary.list.CreatureListComponent.Output as ListOutput

internal class BestiaryMainComponentImpl @Inject constructor(
        val input: ReceiveChannel<Input>,
        private val output: SendChannel<Output>,
        description: BestiaryMainDescription,
        val lifecycle: Lifecycle,
        initialValue: MainInitialValue,
        store: BestiaryMainStore,
        view: BestiaryMainView,
        headerFactory: HeaderAssembler.Factory,
        listFactory: ListAssembler.Factory
) : ComponentBase<BestiaryMainViewDescription, BestiaryMainDescription, BestiaryMainView, BestiaryMainStore>(description, store, view),
        BestiaryMainComponent,
        BestiaryMainComponent.ViewEvents
{
    private val headerInput = BroadcastChannel<HeaderComponent.Input>(Channel.BUFFERED)
    private val headerOutput = BroadcastChannel<HeaderComponent.Output>(Channel.BUFFERED)
    private val headerComponent = headerFactory
            .create(headerInput.openSubscription(), headerOutput, description.header, lifecycle, initialValue.header?:HeaderInitialValueImpl())
            .createComponent()
    override val headerView: HeaderView = headerComponent.view

    private val listInput = BroadcastChannel<ListInput>(Channel.BUFFERED)
    private val listOutput = BroadcastChannel<ListOutput>(Channel.BUFFERED)
    private val listComponent = listFactory
            .create(listInput.openSubscription(), listOutput, description.list, lifecycle, initialValue.list?:CreatureListInitialValueImpl(listOf()))
            .createComponent()
    override val listView: CreatureListView = listComponent.view

    override fun init() {
        super.init()

        addChild(headerComponent)
        addChild(listComponent)

        scope.launch {
            listOutput.asFlow().collect {
                when (it) {
                    is ListOutput.Selected -> {
                        output.send(Output.Selected(it.item))
                    }
                }
            }
        }
    }

    override fun setScroll(value: Float) {
        store.execute(Intent.SetScroll(value))
    }

    override fun getParcel(): Parcelable {
        return MainInitialValueImpl(
                store.state.value.scrollPos,
                headerComponent.getParcel() as HeaderInitialValue,
                listComponent.getParcel() as CreatureListInitialValue
        )
    }
}