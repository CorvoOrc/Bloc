package com.example.witcherbestiary.location.store

import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.data.LocationRepository
import com.example.witcherbestiary.location.initialValue.LocationInitialValue
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.model.Location
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import com.example.witcherbestiary.location.store.CreatureLocationStore.Intent as Intent
import com.example.witcherbestiary.location.store.CreatureLocationStore.State as State

internal class CreatureLocationStoreImpl @Inject constructor(
    initialValue: LocationInitialValue,
    val repository: LocationRepository
) : StoreBase<Intent, State>(State(initialValue.item, initialValue.locations)), CreatureLocationStore {
    private val itemIdFlow = MutableStateFlow(initialValue.item.id)
    private var job: Job = Job()

    override fun init() {
        init(Reducer(state, itemIdFlow))

        scope.launch {
            itemIdFlow.collect {
                if (job.isActive)
                    job.cancel()

                job = scope.launch {
                    try {
                        repository.getCreatureLocations(it).collect {
                            execute(Intent.Update(it))
                        }
                    }
                    catch (e: Exception) { }
                    finally { }
                }
            }
        }
    }

    private class Reducer(val state: StateFlow<State>, val itemIdFlow: MutableStateFlow<String>) : Store.Reducer<Intent, State> {
        override fun reduce(intent: Intent): State {
            return when(intent) {
                is Intent.SetItem -> setItem(intent.item)
                is Intent.Update -> update(intent.items)
            }
        }

        private fun setItem(item: Creature): State {
            if (itemIdFlow.value == item.id)
                return state.value
            itemIdFlow.value = item.id
            return state.value.copy(item = item, locations = listOf())
        }

        private fun update(locations: List<Location>): State =
            state.value.copy(locations = locations)

    }
}