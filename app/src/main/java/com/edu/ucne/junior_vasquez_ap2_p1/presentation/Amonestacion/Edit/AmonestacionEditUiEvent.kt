package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Amonestacion.Edit

import com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.local.AmonestacionEntity

sealed interface AmonestacionEditUiEvent {

    data class Load(val id : Int) : AmonestacionEditUiEvent

    data class NombresChanged(val nombre : String) : AmonestacionEditUiEvent

    data class RazonChanged(val razon : String) : AmonestacionEditUiEvent

    data class MontoChanged(val monto: Double) : AmonestacionEditUiEvent

    data object Save : AmonestacionEditUiEvent
    data object Delete : AmonestacionEditUiEvent
}