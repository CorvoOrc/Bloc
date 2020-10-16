package com.example.witcherbestiary.root

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.Component
import com.example.bloc.component.RootComponentBase
import com.example.bloc.router.Router
import com.example.bloc.store.EmptyStore
import com.example.witcherbestiary.details.BestiaryDetailsComponent
import com.example.witcherbestiary.details.di.BestiaryDetailsAssembler
import com.example.witcherbestiary.details.initialValue.DetailsInitialValue
import com.example.witcherbestiary.details.initialValue.DetailsInitialValueImpl
import com.example.witcherbestiary.main.BestiaryMainComponent
import com.example.witcherbestiary.main.di.BestiaryMainAssembler
import com.example.witcherbestiary.main.initialValue.MainInitialValue
import com.example.witcherbestiary.main.initialValue.MainInitialValueImpl
import com.example.witcherbestiary.root.description.BestiaryRootDescription
import com.example.bloc.value.RootInitialValue
import com.example.bloc.value.RootInitialValueImpl
import com.example.bloc.view.RootViewEvents
import com.example.witcherbestiary.root.view.BestiaryRootView
import com.example.witcherbestiary.root.view.description.BestiaryRootViewDescription
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.root.BestiaryRootComponent.Input as Input
import com.example.witcherbestiary.root.BestiaryRootComponent.Output as Output
import com.example.witcherbestiary.main.BestiaryMainComponent.Input as MainInput
import com.example.witcherbestiary.main.BestiaryMainComponent.Output as MainOutput
import com.example.witcherbestiary.details.BestiaryDetailsComponent.Input as DetailsInput
import com.example.witcherbestiary.details.BestiaryDetailsComponent.Output as DetailsOutput

internal class BestiaryRootComponentImpl @Inject constructor(
        val input: ReceiveChannel<Input>,
        private val output: SendChannel<Output>,
        description: BestiaryRootDescription,
        val lifecycle: Lifecycle,
        initialValue: RootInitialValue,
        router: Router,
        view: BestiaryRootView,
        private val mainFactory: BestiaryMainAssembler.Factory,
        private val detailsFactory: BestiaryDetailsAssembler.Factory
) : RootComponentBase<BestiaryRootViewDescription, BestiaryRootDescription, BestiaryRootView, EmptyStore>(description, initialValue, EmptyStore(router.state), view, router),
        BestiaryRootComponent,
        RootViewEvents
{
    override fun route(node: String, initialValue: Parcelable?) : Component<*, *, *> {
        return when(node) {
            description.main.id -> {
                createMain(if (initialValue != null) initialValue as MainInitialValue else MainInitialValueImpl())
            }
            description.details.id -> {
                createDetails(if (initialValue != null) initialValue as DetailsInitialValue else DetailsInitialValueImpl())
            }
            else -> {
                throw Exception("$node cant routed in BestiaryRootComponentImpl")
            }
        }
    }

    private fun createMain(initialValueImpl: MainInitialValue): BestiaryMainComponent {
        val mainInput = BroadcastChannel<MainInput>(Channel.BUFFERED)
        val mainOutput = BroadcastChannel<MainOutput>(Channel.BUFFERED)
        scope.launch {
            mainOutput.asFlow().collect {
                when (it) {
                    is MainOutput.Selected -> {
                        router.push(description.details.id, DetailsInitialValueImpl(it.item!!))
                    }
                }
            }
        }
        val mainComponent = mainFactory
                .create(mainInput.openSubscription(), mainOutput, description.main, lifecycle, initialValueImpl)
                .createComponent()
        mainComponent.init()
        return mainComponent
    }

    private fun createDetails(initialValue: DetailsInitialValue): BestiaryDetailsComponent {
        val detailsInput = BroadcastChannel<DetailsInput>(Channel.BUFFERED)
        val detailsOutput = BroadcastChannel<DetailsOutput>(Channel.BUFFERED)
        scope.launch {
            detailsOutput.asFlow().collect {
                when (it) {
                    DetailsOutput.Finished -> {
                        router.pop().destroy()
                    }
                }
            }
        }
        val detailsComponent = detailsFactory
                .create(detailsInput.openSubscription(), detailsOutput, description.details, lifecycle, initialValue)
                .createComponent()
        detailsComponent.init()

        scope.launch {
            detailsInput.send(DetailsInput.Select(initialValue.item))
        }
        return detailsComponent
    }

    override fun getParcel(): Parcelable {
        return RootInitialValueImpl(router.getParcel())
    }
}