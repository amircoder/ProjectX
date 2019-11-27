package com.alphacoder.core.data.net.service

import com.alphacoder.core.data.model.job.JobItemResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface JobsService {

    @GET("positions.json")
    fun getJobs(
        @Query("description") description: String,
        @Query("location") location: String
    ): Observable<List<JobItemResponse>>



    @GET("positions.json")
    fun getJobs(
        @Query("description") description: String
    ): Observable<List<JobItemResponse>>

}