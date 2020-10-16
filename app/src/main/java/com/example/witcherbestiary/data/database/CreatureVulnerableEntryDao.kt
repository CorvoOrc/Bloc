package com.example.witcherbestiary.data.database

import androidx.room.Dao
import androidx.room.Query
import com.example.witcherbestiary.model.CreatureVulnerableEntry
import com.example.witcherbestiary.model.Vulnerable
import kotlinx.coroutines.flow.Flow

@Dao
interface CreatureVulnerableEntryDao {
    @Query("SELECT * FROM creature_vulnerable_entries")
    fun getList() : Flow<List<CreatureVulnerableEntry>>

    //@Query("SELECT * FROM vulnerables INNER JOIN (SELECT * FROM creature_vulnerable_entries) ON creature_id = :creatureId")
    @Query("SELECT * FROM vulnerables INNER JOIN creature_vulnerable_entries ON (vulnerables.id = creature_vulnerable_entries.vulnerable_id AND creature_vulnerable_entries.creature_id = :creatureId)")
    fun getCreatureVulnerables(creatureId: String): Flow<List<Vulnerable>>
}