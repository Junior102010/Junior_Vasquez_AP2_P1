package com.edu.ucne.junior_vasquez_ap2_p1.presentation.Navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {

    @Serializable
    data object BorrameList : Screen()

    @Serializable
    data class BorrameEdit(val id: Int = 0) : Screen()

}
