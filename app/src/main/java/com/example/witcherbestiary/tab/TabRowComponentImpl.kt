package com.example.witcherbestiary.tab

import android.os.Parcelable
import androidx.lifecycle.Lifecycle
import com.example.bloc.component.ComponentBase
import com.example.witcherbestiary.tab.description.TabRowDescription
import com.example.witcherbestiary.tab.initialValue.TabRowInitialValue
import com.example.witcherbestiary.tab.initialValue.TabRowInitialValueImpl
import com.example.witcherbestiary.tab.store.TabRowStore
import com.example.witcherbestiary.tab.view.TabRowView
import com.example.witcherbestiary.tab.view.description.TabRowViewDescription
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.witcherbestiary.tab.TabRowComponent.Input as Input
import com.example.witcherbestiary.tab.TabRowComponent.Output as Output
import com.example.witcherbestiary.tab.store.TabRowStore.Intent as Intent

internal class TabRowComponentImpl @Inject constructor(
        val input: ReceiveChannel<Input>,
        private val output: SendChannel<Output>,
        description: TabRowDescription,
        val lifecycle: Lifecycle,
        initialValue: TabRowInitialValue,
        store: TabRowStore,
        view: TabRowView
) : ComponentBase<TabRowViewDescription, TabRowDescription, TabRowView, TabRowStore>(description, store, view),
        TabRowComponent,
        TabRowComponent.ViewEvents
{
    override fun select(index: Int) {
        store.execute(Intent.Set(index))
        scope.launch {
            output.send(Output.Selected(index))
        }
    }

    override fun getParcel(): Parcelable {
        return TabRowInitialValueImpl(
                store.state.value.tabs,
                store.state.value.index
        )
    }
}