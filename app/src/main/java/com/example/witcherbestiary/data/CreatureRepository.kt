package com.example.witcherbestiary.data

import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.flow.Flow

interface CreatureRepository {
    fun getList(): Flow<List<Creature>>
    fun getById(id: String): Flow<Creature>
}