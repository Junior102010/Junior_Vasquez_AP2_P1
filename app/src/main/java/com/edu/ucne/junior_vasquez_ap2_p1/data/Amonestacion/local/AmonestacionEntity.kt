package com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Amonestaciones")
data class AmonestacionEntity(
    @PrimaryKey(autoGenerate = true)
    val amonestacionId : Int = 0,
    val nombres: String,
    val razon : String,
    val monto: Double = 0.0
)