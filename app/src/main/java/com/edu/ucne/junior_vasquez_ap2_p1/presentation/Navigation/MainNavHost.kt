package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Navigation

import android.R.attr.navigationIcon
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edu.ucne.junior_vasquez_ap2_p1.presentation.Borrame.Edit.BorrameEditScreen
import com.edu.ucne.junior_vasquez_ap2_p1.presentation.Borrame.List.BorrameListScreen
import kotlin.random.Random

@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
    innerPadding: PaddingValues
){
    NavHost(
        navController = navController,
        startDestination = Screen.BorrameList,
        modifier = Modifier.padding(innerPadding)
    ){
        composable<Screen.BorrameList> {
            BorrameListScreen(
                onAddBorrame = {
                    navController.navigate(Screen.BorrameEdit())
                },
                onEditBorrame = { id ->
                    navController.navigate(Screen.BorrameEdit(id))
                }
            )
        }
        composable<Screen.BorrameEdit> {
            BorrameEditScreen(
                onBack = {navController.navigateUp()},
                onAdd = {navController.navigateUp()},

            )
        }
    }
}