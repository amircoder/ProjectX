package com.alphacoder.core.data.datasource.remote


import com.alphacoder.core.base.BaseDatasource
import com.alphacoder.core.data.model.job.JobItemResponse
import io.reactivex.Observable

interface JobListRemoteDataSource: BaseDatasource {

    fun getJobListing(description: String, location: String):
            Observable<List<JobItemResponse>>


}