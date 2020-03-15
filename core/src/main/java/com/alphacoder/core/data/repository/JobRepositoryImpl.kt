package com.alphacoder.core.data.repository

import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.data.datasource.local.JobListLocalDataSource
import com.alphacoder.core.data.datasource.remote.JobListRemoteDataSource
import com.alphacoder.core.data.mapper.JobMapper
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.domain.repository.JobRepository
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class JobRepositoryImpl @Inject constructor(
    private val remoteDataSource: JobListRemoteDataSource,
    private val localDataSource: JobListLocalDataSource,
    private val mapper: JobMapper
) : JobRepository {

    override fun getJobListing(
        description: String,
        location: String
    ): Observable<ResultResponse<List<JobItem>, Throwable>> =
        Observable.concatArrayEagerDelayError(
                local(description, location),
                remote(description, location)
            )
            .concatMapEagerDelayError ({
            Observable.just(mapper.map(it))
        }, true)


    private val remote =
        { description: String, location: String ->
            remoteDataSource.getJobListing(description, location)
                .doOnNext { items ->
                    localDataSource.insertOrUpdate(items)
                }
        }

    private val local =
        { description: String, location: String ->
            if (location.isEmpty()) {
                localDataSource.getJobListing(description)
            } else {
                localDataSource.getJobListing(description, location)
            }
        }

}