package com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Repository

import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Borrame
import kotlinx.coroutines.flow.Flow

interface BorrameRepository {

    fun observeBorrame() : Flow<List<Borrame>>

    suspend fun upsert(Borrame : Borrame) : Int

    suspend fun getBorrame(id : Int) : Borrame?

    suspend fun delete(id : Int)
}