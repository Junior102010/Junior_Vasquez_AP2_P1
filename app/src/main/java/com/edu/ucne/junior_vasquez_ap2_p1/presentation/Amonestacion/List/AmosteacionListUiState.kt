package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Amonestacion.List

import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Amonestacion

data class AmonestacionListUiState(
    val isLouding : Boolean = false,
    val amonestaciones: List<Amonestacion> = emptyList(),
    val message: String? = null,
    val navigateToCreate: Boolean = false,
    val navigateToEditId: Int? = null,
    val error: String? = null
)