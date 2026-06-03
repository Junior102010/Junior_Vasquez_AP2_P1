package com.edu.ucne.junior_vasquez_ap2_p1.di

import android.content.Context
import androidx.room.Room
import com.edu.ucne.junior_vasquez_ap2_p1.data.Borrame.local.BorrameDao
import com.edu.ucne.junior_vasquez_ap2_p1.data.database.ResgistroDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRegistroDataBase(@ApplicationContext context: Context): ResgistroDataBase {
        return Room.databaseBuilder(
            context,
            ResgistroDataBase::class.java,
            "RegistroDataBase"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideBorrameDao(database: ResgistroDataBase): BorrameDao {
        return database.BorrameDao()
    }
}
