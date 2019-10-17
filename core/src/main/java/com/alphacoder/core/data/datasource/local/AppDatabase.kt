package com.alphacoder.core.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alphacoder.core.data.datasource.local.dao.JobDao


@Database(
    entities = [(JobItemResponse::class)] ,
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun jobDao(): JobDao
}