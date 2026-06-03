package com.edu.ucne.junior_vasquez_ap2_p1.data.Borrame.local

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface BorrameDao
{
    @Upsert
    suspend fun upsert(entity: BorrameEntity)
}