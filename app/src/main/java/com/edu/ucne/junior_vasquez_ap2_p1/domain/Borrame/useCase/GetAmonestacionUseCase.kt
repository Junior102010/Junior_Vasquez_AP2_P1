package com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase

import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Repository.AmonestacionRepository
import jakarta.inject.Inject

class GetAmonestacionUseCase @Inject constructor(
    private val repository: AmonestacionRepository
)
{
    suspend operator fun invoke(id : Int) = repository.getAmonestacion(id)
}