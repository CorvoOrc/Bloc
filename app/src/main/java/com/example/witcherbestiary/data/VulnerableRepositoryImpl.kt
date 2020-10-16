package com.example.witcherbestiary.data

import com.example.witcherbestiary.data.database.CreatureVulnerableEntryDao
import com.example.witcherbestiary.data.database.VulnerableDao
import com.example.witcherbestiary.model.CreatureVulnerableEntry
import com.example.witcherbestiary.model.Vulnerable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VulnerableRepositoryImpl @Inject constructor(
    private val creatureVulnerableEntryDao: CreatureVulnerableEntryDao,
    private val vulnerableDao: VulnerableDao
) : VulnerableRepository {
    override fun getList(): Flow<List<Vulnerable>> = vulnerableDao.getVulnerables()

    override fun getCreatureVulnerableEntries(): Flow<List<CreatureVulnerableEntry>> = creatureVulnerableEntryDao.getList()

    override fun getCreatureVulnerables(creatureId: String): Flow<List<Vulnerable>> = creatureVulnerableEntryDao.getCreatureVulnerables(creatureId)
}