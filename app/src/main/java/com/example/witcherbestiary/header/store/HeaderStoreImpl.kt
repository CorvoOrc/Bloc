package com.example.witcherbestiary.header.store

import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.header.description.HeaderDescription
import com.example.witcherbestiary.header.initialValue.HeaderInitialValue
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.example.witcherbestiary.header.store.HeaderStore.Intent as Intent
import com.example.witcherbestiary.header.store.HeaderStore.State as State

internal class HeaderStoreImpl @Inject constructor(
    description: HeaderDescription,
    initialValue: HeaderInitialValue
) : StoreBase<Intent, State>(State(initialValue.text?:description.text)), HeaderStore {
    override fun init() {
        init(Reducer(state))
    }

    private class Reducer(val state: StateFlow<State>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when(intent) {
                is Intent.SetText -> setText(intent.text)
            }
        }

        private fun setText(text: String) = state.value.copy(text = text)
    }
}