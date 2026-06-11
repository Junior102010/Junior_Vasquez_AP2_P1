package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edu.ucne.junior_vasquez_ap2_p1.presentation.Amonestacion.Edit.AmonestacionEditUiScreen
import com.edu.ucne.junior_vasquez_ap2_p1.presentation.Amonestacion.List.AmonestacionListScreen

@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
    innerPadding: PaddingValues
){
    NavHost(
        navController = navController,
        startDestination = Screen.AmonestacionList,
        modifier = Modifier.padding(innerPadding)
    ){
        composable<Screen.AmonestacionList> {
            AmonestacionListScreen(
                onAddAmonestacion = {
                    navController.navigate(Screen.AmonestacionEdit(0))
                },
                onEditAmonestacion = { id ->
                    navController.navigate(Screen.AmonestacionEdit(id))
                }
            )
        }
        composable<Screen.AmonestacionEdit> {
            AmonestacionEditUiScreen(
                onBack = {navController.navigateUp()},

            )
        }
    }
}