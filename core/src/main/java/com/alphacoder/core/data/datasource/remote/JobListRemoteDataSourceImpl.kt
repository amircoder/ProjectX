package com.alphacoder.core.data.datasource.remote

import android.util.Log
import com.alphacoder.core.data.model.job.JobItemResponse
import com.alphacoder.core.data.net.service.JobsService
import com.twistedequations.rx2.AndroidRxSchedulers
import io.reactivex.Observable
import javax.inject.Inject

class JobListRemoteDataSourceImpl @Inject constructor(
    val jobService: JobsService,
    schedulers: AndroidRxSchedulers
) : JobListRemoteDataSource {
    override fun getJobListing(
        description: String,
        location: String
    ): Observable<List<JobItemResponse>> =
        jobService.getJobs(description, location)
}