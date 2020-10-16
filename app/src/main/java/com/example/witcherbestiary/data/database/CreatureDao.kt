package com.example.witcherbestiary.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.flow.Flow

@Dao
interface CreatureDao {
    @Query("SELECT * FROM creatures")
    fun getCreatures() : Flow<List<Creature>>
    @Query("SELECT * FROM creatures WHERE id = :id")
    fun getById(id: String): Flow<Creature>
    @Query("SELECT * FROM creatures WHERE id = :id")
    suspend fun getCreature(id: String): Creature
}