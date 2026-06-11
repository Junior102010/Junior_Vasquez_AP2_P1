package com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Repository

import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Amonestacion
import kotlinx.coroutines.flow.Flow

interface AmonestacionRepository {

    fun observeAmonestacion() : Flow<List<Amonestacion>>

    suspend fun upsert(amonestacion : Amonestacion) : Int

    suspend fun getAmonestacion(id : Int) : Amonestacion?

    suspend fun delete(id : Int)
}