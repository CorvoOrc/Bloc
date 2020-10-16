package com.example.witcherbestiary.model

import androidx.compose.runtime.Immutable
import androidx.room.*

@Entity(
    tableName = "creature_vulnerable_entries",
    foreignKeys = [
        ForeignKey(
            entity = Creature::class,
            parentColumns = ["id"],
            childColumns = ["creature_id"]
        ),
        ForeignKey(
            entity = Vulnerable::class,
            parentColumns = ["id"],
            childColumns = ["vulnerable_id"]
        )
    ]
)
@Immutable
data class CreatureVulnerableEntry(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "creature_id") val creatureId: String,
    @ColumnInfo(name = "vulnerable_id") val vulnerableId: String

)