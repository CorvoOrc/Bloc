package com.example.witcherbestiary.app.di

import com.example.witcherbestiary.data.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun bindCreatureRepository(repo: CreatureRepositoryImpl): CreatureRepository

    @Singleton
    @Binds
    abstract fun bindVulnerableRepository(repo: VulnerableRepositoryImpl): VulnerableRepository

    @Singleton
    @Binds
    abstract fun bindLocationRepository(repo: LocationRepositoryImpl): LocationRepository
}