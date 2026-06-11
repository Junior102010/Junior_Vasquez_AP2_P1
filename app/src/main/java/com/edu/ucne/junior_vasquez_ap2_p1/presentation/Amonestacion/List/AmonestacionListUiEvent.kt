package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Amonestacion.List

sealed class AmonestacionListUiEvent{

    object Load : AmonestacionListUiEvent()
    object Refresh : AmonestacionListUiEvent()

    data class ShowMessage(val message: String) : AmonestacionListUiEvent()

    object ClearMessage : AmonestacionListUiEvent()

    object CreateNew : AmonestacionListUiEvent()
    data class Edit(val id: Int) : AmonestacionListUiEvent()

}