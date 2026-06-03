package com.edu.ucne.junior_vasquez_ap2_p1.data.Borrame.Repository

import com.edu.ucne.junior_vasquez_ap2_p1.data.Borrame.local.BorrameDao
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Borrame
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Repository.BorrameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.xml.transform.Source

class BorrameRepositoryImpl @Inject constructor(private val localDateSource: BorrameDao) : BorrameRepository
{
    override fun observeBorrame(): Flow<List<Borrame>> {
        TODO("Not yet implemented")
    }

    override suspend fun upsert(Borrame: Borrame): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getBorrame(id: Int): Borrame? {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int) {
        TODO("Not yet implemented")
    }
}