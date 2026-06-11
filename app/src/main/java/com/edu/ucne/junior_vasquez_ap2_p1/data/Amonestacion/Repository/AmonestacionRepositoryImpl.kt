package com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.Repository

import com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.local.AmonestacionDao
import com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.Mapper.toEntity
import com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.Mapper.toDomain
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Amonestacion
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Repository.AmonestacionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AmonestacionRepositoryImpl @Inject constructor(private val localDataSource: AmonestacionDao) : AmonestacionRepository
{
    override fun observeAmonestacion(): Flow<List<Amonestacion>> {

        return localDataSource.observeAll().map { entities -> entities.map { it.toDomain() } }
    }

    override suspend fun upsert(amonestacion: Amonestacion): Int {
        localDataSource.upsert(amonestacion.toEntity())
        return amonestacion.amonestacionId ?: 0
    }

    override suspend fun getAmonestacion(id: Int): Amonestacion? {
        return localDataSource.getAmonestacion(id)?.toDomain()
    }

    override suspend fun delete(id: Int) {
        localDataSource.deleteById(id)
    }
}