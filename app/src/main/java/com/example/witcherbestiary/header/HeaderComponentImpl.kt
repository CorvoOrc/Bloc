package com.example.witcherbestiary.header

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.ComponentBase
import com.example.witcherbestiary.header.description.HeaderDescription
import com.example.witcherbestiary.header.initialValue.HeaderInitialValue
import com.example.witcherbestiary.header.initialValue.HeaderInitialValueImpl
import com.example.witcherbestiary.header.store.HeaderStore
import com.example.witcherbestiary.header.view.HeaderView
import com.example.witcherbestiary.header.view.description.HeaderViewDescription
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.header.HeaderComponent.Input as Input
import com.example.witcherbestiary.header.HeaderComponent.Output as Output
import com.example.witcherbestiary.header.store.HeaderStore.Intent as Intent

internal class HeaderComponentImpl @Inject constructor(
    val input: ReceiveChannel<Input>,
    private val output: SendChannel<Output>,
    description: HeaderDescription,
    val lifecycle: Lifecycle,
    initialValue: HeaderInitialValue,
    store: HeaderStore,
    view: HeaderView
) : ComponentBase<HeaderViewDescription, HeaderDescription, HeaderView, HeaderStore>(description, store, view), HeaderComponent, HeaderComponent.ViewEvents {
    override fun init() {
        super.init()

        scope.launch {
            input.consumeAsFlow().collect {
                when(it) {
                    is Input.SetText -> store.execute(Intent.SetText(it.text))
                }
            }
        }
    }

    override fun back() {
        scope.launch { output.send(Output.Back) }
    }

    override fun forward() {
        scope.launch { output.send(Output.Forward) }
    }

    override fun getParcel(): Parcelable {
        return HeaderInitialValueImpl(store.state.value.text)
    }
}