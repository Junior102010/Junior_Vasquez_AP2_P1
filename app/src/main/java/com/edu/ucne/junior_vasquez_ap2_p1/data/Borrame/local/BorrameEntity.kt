package com.edu.ucne.junior_vasquez_ap2_p1.data.Borrame.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Borrames")
data class BorrameEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)