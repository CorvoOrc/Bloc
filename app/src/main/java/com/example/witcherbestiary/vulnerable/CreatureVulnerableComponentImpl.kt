package com.example.witcherbestiary.vulnerable

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.ComponentBase
import com.example.witcherbestiary.vulnerable.description.CreatureVulnerableDescription
import com.example.witcherbestiary.vulnerable.initialValue.VulnerableInitialValue
import com.example.witcherbestiary.vulnerable.initialValue.VulnerableInitialValueImpl
import com.example.witcherbestiary.vulnerable.store.CreatureVulnerablesStore
import com.example.witcherbestiary.vulnerable.view.CreatureVulnerableView
import com.example.witcherbestiary.vulnerable.view.description.CreatureVulnerableViewDescription
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.vulnerable.CreatureVulnerableComponent.Input as Input
import com.example.witcherbestiary.vulnerable.CreatureVulnerableComponent.Output as Output
import com.example.witcherbestiary.vulnerable.store.CreatureVulnerablesStore.Intent as Intent

internal class CreatureVulnerableComponentImpl @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    description: CreatureVulnerableDescription,
    val lifecycle: Lifecycle,
    initialValue: VulnerableInitialValue,
    store: CreatureVulnerablesStore,
    view: CreatureVulnerableView
) : ComponentBase<CreatureVulnerableViewDescription, CreatureVulnerableDescription, CreatureVulnerableView, CreatureVulnerablesStore>(description, store, view),
        CreatureVulnerableComponent
{
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
        return VulnerableInitialValueImpl(state.item, state.vulnerables)
    }
}