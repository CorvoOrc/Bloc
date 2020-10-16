package com.example.witcherbestiary.text.store

import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.text.initialValue.TextInitialValue
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.example.witcherbestiary.text.store.TextStore.Intent as Intent
import com.example.witcherbestiary.text.store.TextStore.State as State

internal class TextStoreImpl @Inject constructor(
    initialValue: TextInitialValue
) : StoreBase<Intent, State>(State(initialValue.text)), TextStore {
    override fun init() {
        init(Reducer(state))
    }

    private class Reducer(val state: StateFlow<State>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when(intent) {
                is Intent.Set -> setText(intent.text)
            }
        }

        private fun setText(text: String) = state.value.copy(text = text)
    }
}