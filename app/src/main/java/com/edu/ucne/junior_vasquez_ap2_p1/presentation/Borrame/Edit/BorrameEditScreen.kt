package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Borrame.Edit

import android.R.attr.contentDescription
import android.R.attr.icon
import android.R.attr.navigationIcon
import android.R.id.icon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BorrameEditScreen(
    onBack: () -> Unit,
    onAdd: () -> Unit
)
{


    Scaffold(topBar = {
        TopAppBar(
            title = {Text("Volver a Lista")
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
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAdd,
                modifier = Modifier.testTag("Quiero Volver...Volveeeer Volveeeeeeeer")
            ){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Senore hay que irse"
                )
            }
        }
    ){ innerPadding ->

        Box(
            modifier = Modifier.fillMaxHeight().padding(innerPadding)
        )

        Column(modifier = Modifier.fillMaxHeight())
        {
            Text("Formulario")
        }

    }



}
@Preview
@Composable
private fun BorrameEditBodyPreview() {

}