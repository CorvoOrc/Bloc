package com.example.witcherbestiary.data

import com.example.witcherbestiary.model.CreatureVulnerableEntry
import com.example.witcherbestiary.model.Vulnerable
import kotlinx.coroutines.flow.Flow

interface VulnerableRepository {
    fun getList(): Flow<List<Vulnerable>>
    fun getCreatureVulnerableEntries(): Flow<List<CreatureVulnerableEntry>>
    fun getCreatureVulnerables(creatureId: String): Flow<List<Vulnerable>>
}