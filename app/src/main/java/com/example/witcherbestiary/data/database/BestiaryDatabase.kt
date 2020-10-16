package com.example.witcherbestiary.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.witcherbestiary.model.*

@Database(
    entities = [
        Creature::class,
        Vulnerable::class,
        Location::class,
        CreatureVulnerableEntry::class,
        CreatureLocationEntry::class
    ],
    version = 1,
    exportSchema = false
)
abstract class BestiaryDatabase : RoomDatabase() {
    abstract fun creatureDao(): CreatureDao
    abstract fun vulnerableDao(): VulnerableDao
    abstract fun locationDao(): LocationDao
    abstract fun creatureVulnerableEntry(): CreatureVulnerableEntryDao
    abstract fun creatureLocationEntry(): CreatureLocationEntryDao
}
