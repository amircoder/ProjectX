package com.alphacoder.core.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.alphacoder.core.AppConstant
import com.alphacoder.core.data.datasource.local.dao.JobDao
import com.alphacoder.core.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@NonNull application: Application): AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        AppConstant.DATABASE_NAME
    ).allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideDao(
        appDatabase: AppDatabase
    ): JobDao = appDatabase.jobDao()

}