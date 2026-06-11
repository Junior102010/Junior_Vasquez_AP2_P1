package com.edu.ucne.junior_vasquez_ap2_p1.di

import android.content.Context
import androidx.room.Room
import com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.Repository.AmonestacionRepositoryImpl
import com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.local.AmonestacionDao
import com.edu.ucne.junior_vasquez_ap2_p1.data.database.ResgistroDataBase
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Repository.AmonestacionRepository
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
    fun provideBorrameRepository(amonestacionDao: AmonestacionDao): AmonestacionRepository {
        return AmonestacionRepositoryImpl(amonestacionDao)
    }
    @Provides
    @Singleton
    fun provideBorrameDao(database: ResgistroDataBase): AmonestacionDao {
        return database.AmonestacionDao()
    }
}
