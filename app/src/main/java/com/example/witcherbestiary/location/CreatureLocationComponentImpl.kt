package com.example.witcherbestiary.location

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.ComponentBase
import com.example.witcherbestiary.location.description.CreatureLocationDescription
import com.example.witcherbestiary.location.initialValue.LocationInitialValue
import com.example.witcherbestiary.location.initialValue.LocationInitialValueImpl
import com.example.witcherbestiary.location.store.CreatureLocationStore
import com.example.witcherbestiary.location.view.CreatureLocationView
import com.example.witcherbestiary.location.view.description.CreatureLocationViewDescription
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.location.CreatureLocationComponent.Input as Input
import com.example.witcherbestiary.location.CreatureLocationComponent.Output as Output
import com.example.witcherbestiary.location.store.CreatureLocationStore.Intent as Intent

internal class CreatureLocationComponentImpl @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    description: CreatureLocationDescription,
    val lifecycle: Lifecycle,
    initialValue: LocationInitialValue,
    store: CreatureLocationStore,
    view: CreatureLocationView
) : ComponentBase<CreatureLocationViewDescription, CreatureLocationDescription, CreatureLocationView, CreatureLocationStore>(description, store, view),
        CreatureLocationComponent {
    override fun init() {
        super.init()

        scope.launch {
            input.consumeAsFlow().collect {
                when (it) {
                    is Input.SetItem -> store.execute(Intent.SetItem(it.item))
                }
            }
        }
    }

    override fun getParcel(): Parcelable {
        val state = store.state.value
        return LocationInitialValueImpl(state.item, state.locations)
    }
}