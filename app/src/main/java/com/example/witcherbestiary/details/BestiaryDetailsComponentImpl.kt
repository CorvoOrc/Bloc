package com.example.witcherbestiary.details

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.witcherbestiary.carousel.initialValue.CarouselInitialValueImpl
import com.example.witcherbestiary.carousel.di.CarouselAssembler
import com.example.witcherbestiary.carousel.view.CarouselView
import com.example.bloc.component.ComponentBase
import com.example.bloc.store.EmptyStore
import com.example.witcherbestiary.details.description.BestiaryDetailsDescription
import com.example.witcherbestiary.details.initialValue.DetailsInitialValue
import com.example.witcherbestiary.details.initialValue.DetailsInitialValueImpl
import com.example.witcherbestiary.details.view.BestiaryDetailsView
import com.example.witcherbestiary.details.view.description.BestiaryDetailsViewDescription
import com.example.witcherbestiary.header.di.HeaderAssembler
import com.example.witcherbestiary.header.initialValue.HeaderInitialValue
import com.example.witcherbestiary.header.initialValue.HeaderInitialValueImpl
import com.example.witcherbestiary.header.view.HeaderView
import com.example.witcherbestiary.info.di.InfoAssembler
import com.example.witcherbestiary.info.initialValue.InfoInitialValue
import com.example.witcherbestiary.info.initialValue.InfoInitialValueImpl
import com.example.witcherbestiary.info.view.InfoView
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.details.BestiaryDetailsComponent.Input as Input
import com.example.witcherbestiary.details.BestiaryDetailsComponent.Output as Output
import com.example.witcherbestiary.header.HeaderComponent.Input as HeaderInput
import com.example.witcherbestiary.header.HeaderComponent.Output as HeaderOutput
import com.example.witcherbestiary.carousel.CarouselComponent.Input as CarouselInput
import com.example.witcherbestiary.carousel.CarouselComponent.Output as CarouselOutput
import com.example.witcherbestiary.info.InfoComponent.Input as InfoInput
import com.example.witcherbestiary.info.InfoComponent.Output as InfoOutput

internal class BestiaryDetailsComponentImpl @Inject constructor(
        val input: ReceiveChannel<Input>,
        private val output: SendChannel<Output>,
        description: BestiaryDetailsDescription,
        val lifecycle: Lifecycle,
        initialValue: DetailsInitialValue,
        view: BestiaryDetailsView,
        headerFactory: HeaderAssembler.Factory,
        carouselFactory: CarouselAssembler.Factory,
        infoFactory: InfoAssembler.Factory
) : ComponentBase<BestiaryDetailsViewDescription, BestiaryDetailsDescription, BestiaryDetailsView, EmptyStore>(description, EmptyStore(initialValue), view),
        BestiaryDetailsComponent,
        BestiaryDetailsComponent.ViewEvents {
    private val headerInput = BroadcastChannel<HeaderInput>(Channel.BUFFERED)
    private val headerOutput = BroadcastChannel<HeaderOutput>(Channel.BUFFERED)
    private val headerComponent = headerFactory
            .create(headerInput.openSubscription(), headerOutput, description.header, lifecycle, initialValue.header?:HeaderInitialValueImpl(initialValue.item!!.name))
            .createComponent()
    override val headerView: HeaderView = headerComponent.view

    private val carouselInput = BroadcastChannel<CarouselInput>(Channel.BUFFERED)
    private val carouselOutput = BroadcastChannel<CarouselOutput>(Channel.BUFFERED)
    private val carouselComponent = carouselFactory
            .create(carouselInput.openSubscription(), carouselOutput, description.carousel, lifecycle, initialValue.carousel?: CarouselInitialValueImpl(initialValue.item!!))
            .createComponent()
    override val carouselView: CarouselView = carouselComponent.view

    private val infoInput = BroadcastChannel<InfoInput>(Channel.BUFFERED)
    private val infoOutput = BroadcastChannel<InfoOutput>(Channel.BUFFERED)
    private val infoComponent = infoFactory
            .create(infoInput.openSubscription(), infoOutput, description.info, lifecycle,initialValue.info?: InfoInitialValueImpl(initialValue.item!!))
            .createComponent()
    override val infoView: InfoView = infoComponent.view

    override fun init() {
        super.init()

        addChild(headerComponent)
        addChild(carouselComponent)
        addChild(infoComponent)

        scope.launch {
            input.consumeAsFlow().collect {
                when (it) {
                    is Input.Select -> carouselInput.send(CarouselInput.SetSelection(it.item))
                }
            }
        }
        scope.launch {
            carouselOutput.asFlow().collect {
                when (it) {
                    is CarouselOutput.Changed -> {
                        headerInput.send(HeaderInput.SetText(it.item.name))
                        infoInput.send(InfoInput.SetItem(it.item))
                    }
                    is CarouselOutput.Updated -> {
                        if (it.item != null) {
                            headerInput.send(HeaderInput.SetText(it.item.name))
                            infoInput.send(InfoInput.SetItem(it.item))
                        }
                    }
                }
            }
        }
        scope.launch {
            headerOutput.asFlow().collect {
                when (it) {
                    HeaderOutput.Back -> output.send(Output.Finished)
                }
            }
        }
    }

    override fun getParcel(): Parcelable {
        val carouselParcel = carouselComponent.getParcel() as CarouselInitialValueImpl
        return DetailsInitialValueImpl(
                carouselParcel.selection,
                headerComponent.getParcel() as HeaderInitialValue,
                carouselParcel,
                infoComponent.getParcel() as InfoInitialValue
        )
    }
}