package com.edu.ucne.junior_vasquez_ap2_p1.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.local.AmonestacionDao
import com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.local.AmonestacionEntity

@Database(
    entities = [AmonestacionEntity :: class],
    version = 3
)
abstract class ResgistroDataBase : RoomDatabase()
{
    abstract fun AmonestacionDao() : AmonestacionDao
}