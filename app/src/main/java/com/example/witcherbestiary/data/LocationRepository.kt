package com.example.witcherbestiary.data

import com.example.witcherbestiary.model.CreatureLocationEntry
import com.example.witcherbestiary.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getList(): Flow<List<Location>>
    fun getCreatureLocationEntries(): Flow<List<CreatureLocationEntry>>
    fun getCreatureLocations(creatureId: String): Flow<List<Location>>
}