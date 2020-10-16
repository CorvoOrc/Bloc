package com.example.witcherbestiary.data

import com.example.witcherbestiary.data.database.CreatureLocationEntryDao
import com.example.witcherbestiary.data.database.LocationDao
import com.example.witcherbestiary.model.CreatureLocationEntry
import com.example.witcherbestiary.model.Location
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val creatureLocationEntryDao: CreatureLocationEntryDao,
    private val locationDao: LocationDao
) : LocationRepository {
    override fun getList(): Flow<List<Location>> = locationDao.getLocations()

    override fun getCreatureLocationEntries(): Flow<List<CreatureLocationEntry>> = creatureLocationEntryDao.getList()

    override fun getCreatureLocations(creatureId: String): Flow<List<Location>> = creatureLocationEntryDao.getCreatureLocations(creatureId)
}