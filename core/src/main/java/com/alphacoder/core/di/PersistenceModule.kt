package com.alphacoder.core.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import androidx.room.RoomDatabase
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
    fun provideAppDatabase(@NonNull application: Application)
            : AppDatabase = AppDatabase.getInstance(application)


    @Provides
    @Singleton
    fun provideDao(
        appDatabase: AppDatabase
    ): JobDao = appDatabase.jobDao()

}