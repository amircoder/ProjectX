package com.alphacoder.core.data.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alphacoder.core.AppConstant
import com.alphacoder.core.BuildConfig
import com.alphacoder.core.data.datasource.local.dao.JobDao
import com.alphacoder.core.data.model.job.JobItemResponse


@Database(
    entities = [(JobItemResponse::class)] ,
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        fun getInstance(context: Context)
                : AppDatabase =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                BuildConfig.DB_NAME
            ).allowMainThreadQueries().build()

        fun getTestInstance(context: Context)
                = Room.inMemoryDatabaseBuilder(context,
            AppDatabase::class.java).allowMainThreadQueries().build()

    }


    abstract fun jobDao(): JobDao


}