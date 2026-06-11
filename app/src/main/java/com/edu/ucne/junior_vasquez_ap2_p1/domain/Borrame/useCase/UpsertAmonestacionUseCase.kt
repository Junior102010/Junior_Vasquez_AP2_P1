package com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase

import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Amonestacion
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Repository.AmonestacionRepository
import jakarta.inject.Inject

class UpsertAmonestacionUseCase @Inject constructor(
    private val repository: AmonestacionRepository
)
{
    suspend operator fun invoke(amonestacion: Amonestacion) : Result<Int>
    {
        val nombreResult = validateNombre(amonestacion.nombres)
        if(!nombreResult.isValid){
            return Result.failure(IllegalArgumentException(nombreResult.error))
        }

        val razonResult = validateRazon(amonestacion.razon)
        if(!razonResult.isValid){
            return Result.failure(IllegalArgumentException(razonResult.error))
        }

        val montoResult = validateMonto(amonestacion.monto)
        if(!montoResult.isValid){
            return Result.failure(IllegalArgumentException(montoResult.error))
        }

        return runCatching { repository.upsert(amonestacion) }
    }
}