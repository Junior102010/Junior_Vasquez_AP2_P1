package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Amonestacion.Edit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Amonestacion
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase.DeleteAmonestacionUseCase
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase.GetAmonestacionUseCase
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase.ObserveAmonestacionUseCase
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase.UpsertAmonestacionUseCase
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase.validateMonto
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase.validateNombre
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase.validateRazon
import com.edu.ucne.junior_vasquez_ap2_p1.presentation.Navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class AmonestacionEditUiViewModel @Inject constructor(
    private val upsertAmonestacionUseCase: UpsertAmonestacionUseCase,
    private val observeAmonestacionUseCase: ObserveAmonestacionUseCase,
    private val getAmonestacionUseCase: GetAmonestacionUseCase,
    private val deleteAmonestacionUseCase: DeleteAmonestacionUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val routeArgs = savedStateHandle.toRoute<Screen.AmonestacionEdit>()
    private val amonestacionId : Int = routeArgs.id

    private val _state = MutableStateFlow(AmonestacionEditUiState())
    val state : StateFlow<AmonestacionEditUiState> = _state.asStateFlow()

    private fun loadAmonestacion(id:Int?)
    {
        if(id == null || id ==0){
            _state.update { it.copy(isNew = true, id = null) }
            return
        }

        viewModelScope.launch {
            val amonestacion = getAmonestacionUseCase(id)
            if(amonestacion != null){
                _state.update {
                    it.copy(
                        isNew = false,
                        id = amonestacion.amonestacionId,
                        nombres = amonestacion.nombres,
                        monto = amonestacion.monto,
                        razon = amonestacion.razon

                    )
                }
            }else
            {
                _state.update { it.copy(isNew = true, id = null) }

            }
        }
    }

    init {
        loadAmonestacion(amonestacionId)
    }

    fun onEvent(event: AmonestacionEditUiEvent){
        when(event){
            is AmonestacionEditUiEvent.Load -> loadAmonestacion(event.id)
            is AmonestacionEditUiEvent.NombresChanged -> _state.update{
                it.copy(nombres = event.nombre, nombreError = null)
            }
            is AmonestacionEditUiEvent.MontoChanged -> _state.update{
                it.copy(monto = event.monto, montoError = null)
            }
            is AmonestacionEditUiEvent.RazonChanged -> _state.update{
                it.copy(razon = event.razon, razonError = null)
            }

            AmonestacionEditUiEvent.Save -> onSave()
            AmonestacionEditUiEvent.Delete -> onDelete()
        }
    }

    private fun onSave() {

        viewModelScope.launch {
            val nombre = state.value.nombres
            val razon = state.value.razon
            val monto = state.value.monto
            val nombreValidation = validateNombre(nombre)
            val razonValidations = validateRazon(razon)
            val montoValidations = validateMonto(monto)


            if (!nombreValidation.isValid || !razonValidations.isValid || !montoValidations.isValid) {
                _state.update {
                    it.copy(
                        nombreError = nombreValidation.error,
                        montoError = montoValidations.error,
                        razonError = razonValidations.error,
                    )
                }
                return@launch
            }


            _state.update { it.copy(isSaving = true) }

            val amonestacion = Amonestacion(
                amonestacionId = state.value.id ?: 0,
                nombres = nombre,
                razon = razon,
                monto = state.value.monto
            )

            val result = upsertAmonestacionUseCase(amonestacion)
            result.onSuccess { newId ->
                _state.update {
                    it.copy(
                        isSaving = false,
                        saved = true,
                        id = newId,
                        isNew = false
                    )
                }
            }.onFailure {
                _state.update { it.copy(isSaving = false) }
            }
        }
    }

    private fun onDelete()
    {
        val id = state.value.id ?: return
        viewModelScope.launch {
            _state.update { it.copy(isDeleting = true) }
            deleteAmonestacionUseCase(id)
            _state.update { it.copy(isDeleting = false, deleted = true) }
        }
    }

}