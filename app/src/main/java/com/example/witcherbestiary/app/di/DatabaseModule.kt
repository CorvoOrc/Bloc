package com.example.witcherbestiary.app.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.bloc.description.DescriptionGraph
import com.example.witcherbestiary.data.database.*
import com.example.witcherbestiary.root.description.BestiaryRootDescription
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context, description: DescriptionGraph<BestiaryRootDescription>): BestiaryDatabase {
        val dbInitializer = DatabaseInitializer()
        return Room.databaseBuilder(context, BestiaryDatabase::class.java, description.database)
            .addCallback(
                object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        dbInitializer.prepopulate(db)
                    }
                }
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideCreatureDao(database: BestiaryDatabase): CreatureDao = database.creatureDao()

    @Singleton
    @Provides
    fun provideCreatureVulnerableEntryDao(database: BestiaryDatabase): CreatureVulnerableEntryDao = database.creatureVulnerableEntry()

    @Singleton
    @Provides
    fun provideVulnerableDao(database: BestiaryDatabase): VulnerableDao = database.vulnerableDao()

    @Singleton
    @Provides
    fun provideCreatureLocationEntryDao(database: BestiaryDatabase): CreatureLocationEntryDao = database.creatureLocationEntry()

    @Singleton
    @Provides
    fun provideLocationDao(database: BestiaryDatabase): LocationDao = database.locationDao()
}