package com.example.witcherbestiary.text

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.ComponentBase
import com.example.witcherbestiary.text.description.TextDescription
import com.example.witcherbestiary.text.initialValue.TextInitialValue
import com.example.witcherbestiary.text.initialValue.TextInitialValueImpl
import com.example.witcherbestiary.text.store.TextStore
import com.example.witcherbestiary.text.view.TextView
import com.example.witcherbestiary.text.view.description.TextViewDescription
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.text.TextComponent.Input as Input
import com.example.witcherbestiary.text.TextComponent.Output as Output
import com.example.witcherbestiary.text.store.TextStore.Intent as Intent

internal class TextComponentImpl @Inject constructor(
        val input: ReceiveChannel<Input>,
        private val output: SendChannel<Output>,
        description: TextDescription,
        val lifecycle: Lifecycle,
        initialValue: TextInitialValue,
        store: TextStore,
        view: TextView
) : ComponentBase<TextViewDescription, TextDescription, TextView, TextStore>(description, store, view),
        TextComponent {
    override fun init() {
        super.init()

        scope.launch {
            input.consumeAsFlow().collect {
                when(it) {
                    is Input.Set -> store.execute(Intent.Set(it.text))
                }
            }
        }
    }

    override fun getParcel(): Parcelable {
        return TextInitialValueImpl(store.state.value.text)
    }
}