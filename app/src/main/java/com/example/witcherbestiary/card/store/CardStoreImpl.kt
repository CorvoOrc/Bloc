package com.example.witcherbestiary.card.store

import com.example.witcherbestiary.card.initialValue.CardInitialValue
import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.data.CreatureRepository
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import java.lang.Exception
import javax.inject.Inject
import com.example.witcherbestiary.card.store.CardStore.Intent as Intent
import com.example.witcherbestiary.card.store.CardStore.State as State

internal class CardStoreImpl @Inject constructor(
    initialValue: CardInitialValue,
    val repository: CreatureRepository
) : StoreBase<Intent, State>(State(initialValue.item)), CardStore {
    private val itemIdFlow = MutableStateFlow(initialValue.item.id)
    private var job: Job = Job()

    override fun init() {
        init(Reducer(state, itemIdFlow))

        scope.launch {
            itemIdFlow.collect {
                if (job.isActive)
                    job.cancel()

                job = launch {
                    try{
                        repository.getById(it).collect {
                            if (it != null)
                                execute(Intent.UpdateItem(it))
                        }
                    }
                    catch (e: Exception) { }
                    finally { }
                }
            }
        }
    }

    private class Reducer(val state: StateFlow<State>, val itemIdFlow: MutableStateFlow<String>) :
        Store.Reducer<Intent, State> {

        override fun reduce(intent: Intent): State {
            return when (intent) {
                is Intent.SetItem -> setItem(intent.item)
                is Intent.UpdateItem -> updateItem(intent.item)
            }
        }

        private fun setItem(item: Creature): State {
            itemIdFlow.value = item.id
            return state.value.copy(item = item)
        }

        private fun updateItem(item: Creature): State {
            if (state.value.item.id != item.id)
                return state.value
            return state.value.copy(item = item)
        }
    }
}