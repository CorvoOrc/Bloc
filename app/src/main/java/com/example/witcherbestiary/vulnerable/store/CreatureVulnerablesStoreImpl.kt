package com.example.witcherbestiary.vulnerable.store

import com.example.bloc.store.Store
import com.example.bloc.store.StoreBase
import com.example.witcherbestiary.data.VulnerableRepository
import com.example.witcherbestiary.model.Creature
import com.example.witcherbestiary.model.Vulnerable
import com.example.witcherbestiary.vulnerable.initialValue.VulnerableInitialValue
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import com.example.witcherbestiary.vulnerable.store.CreatureVulnerablesStore.Intent as Intent
import com.example.witcherbestiary.vulnerable.store.CreatureVulnerablesStore.State as State

internal class CreatureVulnerablesStoreImpl @Inject constructor(
    initialValue: VulnerableInitialValue,
    val repository: VulnerableRepository
) : StoreBase<Intent, State>(State(initialValue.item, initialValue.vulnerables)), CreatureVulnerablesStore {
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
                        repository.getCreatureVulnerables(it).collect {
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
            return state.value.copy(item = item, vulnerables = listOf())
        }

        private fun update(vulnerables: List<Vulnerable>): State =
                state.value.copy(vulnerables = vulnerables)
    }
}