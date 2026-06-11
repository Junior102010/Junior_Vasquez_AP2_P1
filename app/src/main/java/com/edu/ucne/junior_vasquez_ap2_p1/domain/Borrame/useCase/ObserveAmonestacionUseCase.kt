package com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase

import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Amonestacion
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Repository.AmonestacionRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class ObserveAmonestacionUseCase @Inject constructor(
    private val repository: AmonestacionRepository
)
{
    operator fun invoke() : Flow<List<Amonestacion>> = repository.observeAmonestacion()
}