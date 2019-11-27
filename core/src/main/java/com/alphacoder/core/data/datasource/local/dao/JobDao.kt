package com.alphacoder.core.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alphacoder.core.AppConstant
import com.alphacoder.core.data.datasource.local.JobListLocalDataSource
import com.alphacoder.core.data.model.job.JobItemResponse
import io.reactivex.Observable


@Dao
interface JobDao: JobListLocalDataSource {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insertOrUpdate(jobItems: List<JobItemResponse>)

    @Query("SELECT * FROM ${AppConstant.TABLE_NAME_JOB} WHERE description like '%' || :description || '%' AND location like '%' || :location || '%' ")
    override fun getJobListing(description: String, location: String ): Observable<List<JobItemResponse>>

    @Query("SELECT * FROM ${AppConstant.TABLE_NAME_JOB} WHERE description like '%' || :description || '%' ")
    override fun getJobListing(description: String ): Observable<List<JobItemResponse>>

    @Query("SELECT * FROM ${AppConstant.TABLE_NAME_JOB}")
    fun getJobListing(): Observable<List<JobItemResponse>>

}