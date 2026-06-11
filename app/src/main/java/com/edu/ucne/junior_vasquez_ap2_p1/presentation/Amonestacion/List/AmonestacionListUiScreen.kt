package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Amonestacion.List

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Amonestacion

@Composable
fun AmonestacionListScreen(
    viewModel: AmonestacionListViewModel = hiltViewModel(),
    onAddAmonestacion: () -> Unit,
    onEditAmonestacion: (Int) -> Unit,
){

    val state by viewModel.state.collectAsStateWithLifecycle()

    AmonestacionListBody(
        state = state,
        onEvent = viewModel::onEvent,
        onAddAmonestacion = onAddAmonestacion,
        onEditAmonestacion = onEditAmonestacion
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmonestacionListBody(
    state: AmonestacionListUiState,
    onAddAmonestacion: () -> Unit,
    onEditAmonestacion: (Int) -> Unit,
    onEvent: (AmonestacionListUiEvent) -> Unit
){

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.message) {
        state.message?.let{ message ->
            snackbarHostState.showSnackbar(message)
            onEvent(AmonestacionListUiEvent.ClearMessage)
        }
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {Text("Lista de Amonestaciones")})

    },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddAmonestacion,
                modifier = Modifier.testTag("Agregar")
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar una Amonestacion"
                )
            }
        }
    ) {padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            if(state.isLouding){
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .testTag("cargando")
                )
            }
            else{

                if(state.amonestaciones.isEmpty()){
                    Text(
                        text = "No hay Amonestaciones",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .testTag("NohayAmonestaciones")
                    )
                }
                else{
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .testTag("AmonestacionesLIst"),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(
                            items = state.amonestaciones,
                            key = {it.amonestacionId}
                        ){ amonestacion ->
                            AmonestacionItem(
                                amonestacion = amonestacion,
                                onEdit = {onEditAmonestacion(amonestacion.amonestacionId)}

                            )


                        }
                    }
                }

            }
        }

    }
}

@Composable
fun AmonestacionItem(amonestacion: Amonestacion, onEdit: () -> Unit)
{
    ElevatedCard( modifier = Modifier
        .fillMaxHeight()
        .clickable { onEdit() }
        .testTag("Amonestacion_${amonestacion.amonestacionId}"))
    {
        Row( modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Column(modifier = Modifier.weight(1f)){

                Text(
                    text = "Nombre/s: ${amonestacion.nombres}",
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = "Razon: ${amonestacion.razon}",
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = "Monto = ${amonestacion.monto} RD$",
                    style = MaterialTheme.typography.bodyLarge
                )

            }


        }
    }
}