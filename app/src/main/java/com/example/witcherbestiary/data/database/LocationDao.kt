package com.example.witcherbestiary.data.database

import androidx.room.Dao
import androidx.room.Query
import com.example.witcherbestiary.model.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Query("SELECT * FROM locations")
    fun getLocations(): Flow<List<Location>>
}