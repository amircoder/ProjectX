package com.alphacoder.core.data.datasource.remote

import com.alphacoder.core.data.model.job.JobItemResponse
import com.alphacoder.core.data.net.service.JobsService
import io.reactivex.Observable
import javax.inject.Inject

class JobListRemoteDataSourceImpl @Inject constructor(
    private val jobService: JobsService
) : JobListRemoteDataSource {

    override fun getJobListing(
        description: String,
        location: String
    ): Observable<List<JobItemResponse>> =
        if (location.isBlank())
            jobService.getJobs(description)
        else
            jobService.getJobs(description, location)

}