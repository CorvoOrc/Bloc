package com.example.witcherbestiary.data

import com.example.witcherbestiary.data.database.CreatureDao
import com.example.witcherbestiary.model.Creature
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreatureRepositoryImpl @Inject constructor(
        private val creatureDao: CreatureDao
) : CreatureRepository {
    override fun getList(): Flow<List<Creature>> = creatureDao.getCreatures()

    override fun getById(id: String): Flow<Creature> = creatureDao.getById(id)
}