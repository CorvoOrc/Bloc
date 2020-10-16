package com.example.witcherbestiary.model

import androidx.compose.runtime.Immutable
import androidx.room.*

@Entity(
    tableName = "creature_location_entries",
    foreignKeys = [
        ForeignKey(
            entity = Creature::class,
            parentColumns = ["id"],
            childColumns = ["creature_id"]
        ),
        ForeignKey(
            entity = Location::class,
            parentColumns = ["id"],
            childColumns = ["location_id"]
        )
    ]
)
@Immutable
data class CreatureLocationEntry(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "creature_id") val creatureId: String,
    @ColumnInfo(name = "location_id") val locationId: String
)