package com.alphacoder.core.domain.usecase

import com.alphacoder.core.base.BaseUseCase
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.domain.repository.JobRepository
import com.twistedequations.rx2.AndroidRxSchedulers
import javax.inject.Inject

class JobUseCaseImpl @Inject constructor(
    private val jobRepository: JobRepository,
    androidRxSchedulers: AndroidRxSchedulers
) : JobUseCase,
    BaseUseCase<ResultResponse<List<JobItem>, Throwable>, List<JobItem>, Throwable>(
    androidRxSchedulers
) {
    override fun execute(
        page: Int,
        description: String,
        location: String,
        onSuccess: (ResultResponse<List<JobItem>, Throwable>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        jobRepository.getJobListing(description, location)
            .executeUseCase(onSuccess, onFailure)

    }

}