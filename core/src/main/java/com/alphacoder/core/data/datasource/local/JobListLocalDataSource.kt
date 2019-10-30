package com.alphacoder.core.data.datasource.local


import com.alphacoder.core.data.model.job.JobItemResponse
import io.reactivex.Observable

interface JobListLocalDataSource {

    fun insertOrUpdate(jobItems: List<JobItemResponse>)

    fun getJobListing(): Observable<List<JobItemResponse>>
}