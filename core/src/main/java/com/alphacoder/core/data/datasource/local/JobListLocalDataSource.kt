package com.alphacoder.core.data.datasource.local


import com.alphacoder.core.base.BaseRepository
import com.alphacoder.core.data.model.job.JobItemResponse
import io.reactivex.Observable

interface JobListLocalDataSource: BaseRepository {

    fun insertOrUpdate(jobItems: List<JobItemResponse>)

    fun getJobListing(description: String, location: String ): Observable<List<JobItemResponse>>

    fun getJobListing(description: String): Observable<List<JobItemResponse>>

}