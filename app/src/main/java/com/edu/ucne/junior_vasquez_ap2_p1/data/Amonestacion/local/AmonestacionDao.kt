package com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AmonestacionDao
{
    @Upsert
    suspend fun upsert(entity: AmonestacionEntity)

    @Delete
    suspend fun delete(borrame: AmonestacionEntity)

    @Query("DELETE FROM Amonestaciones WHERE amonestacionId = :id")
    suspend fun deleteById(id : Int)

    @Query("SELECT * FROM Amonestaciones where amonestacionId = :id ")
    suspend fun getAmonestacion(id : Int): AmonestacionEntity?

    @Query("SELECT * FROM Amonestaciones ORDER BY amonestacionId")
    fun observeAll(): Flow<List<AmonestacionEntity>>

}