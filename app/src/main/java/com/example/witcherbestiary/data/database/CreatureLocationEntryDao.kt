package com.example.witcherbestiary.data.database

import androidx.room.Dao
import androidx.room.Query
import com.example.witcherbestiary.model.CreatureLocationEntry
import com.example.witcherbestiary.model.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface CreatureLocationEntryDao {
    @Query("SELECT * FROM creature_location_entries")
    fun getList() : Flow<List<CreatureLocationEntry>>

    @Query("SELECT * FROM locations INNER JOIN creature_location_entries ON (locations.id = creature_location_entries.location_id AND creature_location_entries.creature_id = :creatureId)")
    fun getCreatureLocations(creatureId: String): Flow<List<Location>>
}