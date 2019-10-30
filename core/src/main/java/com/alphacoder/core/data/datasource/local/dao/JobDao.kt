package com.alphacoder.core.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alphacoder.core.data.datasource.local.JobListLocalDataSource
import com.alphacoder.core.data.model.job.JobItemResponse
import io.reactivex.Observable


@Dao
interface JobDao: JobListLocalDataSource {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insertOrUpdate(jobItems: List<JobItemResponse>)

    @Query("SELECT * FROM jobs")
    override fun getJobListing(): Observable<List<JobItemResponse>>

}