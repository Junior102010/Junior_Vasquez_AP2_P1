package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Amonestacion.Edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlin.toString

@Composable
fun AmonestacionEditUiScreen(
    viewModel: AmonestacionEditUiViewModel = hiltViewModel(),
    onBack: () -> Unit,
)
{
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.saved,state.deleted) {
        if(state.saved || state.deleted){
            onBack()
        }
    }

    AmonestacionEditBody(
        state = state,
        onEvent = viewModel::onEvent,
        onBack = onBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmonestacionEditBody(
    state: AmonestacionEditUiState, onEvent: (AmonestacionEditUiEvent) -> Unit, onBack: () -> Unit
) {




    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(if (state.isNew) "Agregar Amonestacion" else "Editar Amonestacion")

                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }

            )
        },

        ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = state.nombres,
                onValueChange = { onEvent(AmonestacionEditUiEvent.NombresChanged(it)) },
                label = { Text("Nombre/s") },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("input_nombre"),
                isError = state.nombreError != null,
                supportingText =  state.nombreError?.let  {{ Text(it) } },
                singleLine = true
            )

            OutlinedTextField(
                value = state.razon,
                onValueChange = { onEvent(AmonestacionEditUiEvent.RazonChanged(it)) },
                label = { Text("Razon o Motivo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("input_razon"),
                isError = state.razonError != null,
                supportingText =  state.razonError?.let  {{ Text(it) } },
                singleLine = true
            )



            OutlinedTextField(
                value = state.monto.toString(),
                onValueChange = { onEvent(AmonestacionEditUiEvent.MontoChanged(it.toDouble())) },
                label = { Text("Monto") },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("input_Monto"),
                isError = state.montoError != null,
                supportingText =  state.montoError?.let { { Text(it) } },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (!state.isNew) {
                    Button(
                        onClick = { onEvent(AmonestacionEditUiEvent.Delete) },
                        modifier = Modifier
                            .weight(1f)
                            .testTag("btn_eliminar"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        ),
                        enabled = !state.isDeleting
                    ) {
                        if (state.isDeleting) {
                            CircularProgressIndicator(modifier = Modifier.size(24.dp))
                        } else {
                            Icon(Icons.Default.Delete, contentDescription = null)
                            Spacer(Modifier.size(8.dp))
                            Text("Eliminar")
                        }
                    }
                }

                Button(
                    onClick = { onEvent(AmonestacionEditUiEvent.Save) },
                    modifier = Modifier
                        .weight(if (state.isNew) 1f else 2f)
                        .testTag("btn_guardar"),
                    enabled = !state.isSaving
                ) {
                    if (state.isSaving) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    } else {
                        Text("Guardar")
                    }
                }
            }

        }


    }
}