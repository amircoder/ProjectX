package com.alphacoder.core.domain.repository


import com.alphacoder.core.base.BaseRepository
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import io.reactivex.Observable


interface JobRepository: BaseRepository {

    fun getJobListing(description: String, location: String):
            Observable<ResultResponse<List<JobItem>, Throwable>>

}