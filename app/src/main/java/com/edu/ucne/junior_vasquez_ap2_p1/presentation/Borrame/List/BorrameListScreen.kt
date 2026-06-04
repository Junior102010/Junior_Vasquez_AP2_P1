package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Borrame.List

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BorrameListScreen(
    onAddBorrame: () -> Unit,
    onEditBorrame: (Int) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddBorrame,
                modifier = Modifier.testTag("PasarAEdit")
            ) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Editar un Borrame"
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
        }

        Column(modifier = Modifier.fillMaxHeight())
        {
            Row( modifier = Modifier.fillMaxWidth())
            {
                Text("Numero", modifier = Modifier.weight(1f))
                Text("Fecha", modifier = Modifier.weight(1f))
                Text("Balance", modifier = Modifier.weight(2f))
            }

            for (i in 1..5){
                Row(modifier = Modifier.fillMaxWidth())
                {
                    Text("$i", modifier = Modifier.weight(1f))
                    Text("23/$i/197$i", modifier = Modifier.weight(1f))
                    Text("$i 800", modifier = Modifier.weight(2f))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BorrameListBodyPreview() {
    BorrameListScreen(
        onAddBorrame = {},
        onEditBorrame = {}
    )
}
