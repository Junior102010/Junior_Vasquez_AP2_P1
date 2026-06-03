package com.edu.ucne.junior_vasquez_ap2_p1.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edu.ucne.junior_vasquez_ap2_p1.data.Borrame.local.BorrameDao
import com.edu.ucne.junior_vasquez_ap2_p1.data.Borrame.local.BorrameEntity

@Database(
    entities = [BorrameEntity :: class],
    version = 1
)
abstract class ResgistroDataBase : RoomDatabase()
{
    abstract fun BorrameDao() : BorrameDao
}