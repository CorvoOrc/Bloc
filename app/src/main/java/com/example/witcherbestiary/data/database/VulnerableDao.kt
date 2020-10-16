package com.example.witcherbestiary.data.database

import androidx.room.Dao
import androidx.room.Query
import com.example.witcherbestiary.model.Vulnerable
import kotlinx.coroutines.flow.Flow

@Dao
interface VulnerableDao {
    @Query("SELECT * FROM vulnerables")
    fun getVulnerables(): Flow<List<Vulnerable>>
}