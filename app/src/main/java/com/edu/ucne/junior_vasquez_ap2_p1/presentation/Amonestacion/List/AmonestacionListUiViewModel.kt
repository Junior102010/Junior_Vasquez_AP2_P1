package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Amonestacion.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase.DeleteAmonestacionUseCase
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase.ObserveAmonestacionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class AmonestacionListViewModel @Inject constructor(
    private val observeAmonestacionUseCase: ObserveAmonestacionUseCase,
    private val deleteAmonestacionUseCase: DeleteAmonestacionUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(AmonestacionListUiState(isLouding = true))
    val state : StateFlow<AmonestacionListUiState> = _state.asStateFlow()

    fun loadAmonestacion()
    {
        viewModelScope.launch {
            _state.update { it.copy(isLouding = true) }
            observeAmonestacionUseCase().collectLatest { list ->
                _state.update { it.copy(isLouding = false, amonestaciones = list,message = null) }
            }
        }
    }

    init {
        loadAmonestacion()
    }

    fun onEvent(event: AmonestacionListUiEvent){

        when(event){
            AmonestacionListUiEvent.Load -> loadAmonestacion()
            AmonestacionListUiEvent.Refresh -> loadAmonestacion()
            is AmonestacionListUiEvent.ShowMessage -> _state.update { it.copy(message = event.message) }
            AmonestacionListUiEvent.ClearMessage -> _state.update { it.copy(message = null) }
            AmonestacionListUiEvent.CreateNew -> _state.update { it.copy(navigateToCreate = true) }
            is AmonestacionListUiEvent.Edit -> _state.update { it.copy(navigateToEditId = event.id) }
        }

    }

}