package com.edu.ucne.junior_vasquez_ap2_p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.edu.ucne.junior_vasquez_ap2_p1.presentation.Navigation.MainNavHost
import com.edu.ucne.junior_vasquez_ap2_p1.ui.theme.Junior_Vasquez_AP2_P1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Junior_Vasquez_AP2_P1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainNavHost(innerPadding = innerPadding)
                }
            }
        }
    }
}
