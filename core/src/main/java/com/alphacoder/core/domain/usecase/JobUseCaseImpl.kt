package com.alphacoder.core.domain.usecase

import com.alphacoder.core.base.BaseUseCase
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.domain.repository.JobRepository
import com.alphacoder.core.rx.SchedulerProvider
import javax.inject.Inject

class JobUseCaseImpl @Inject constructor(
    private val jobRepository: JobRepository,
    androidSchedulers: SchedulerProvider
) : JobUseCase,
    BaseUseCase<ResultResponse<List<JobItem>, Throwable>, List<JobItem>, Throwable>(
        androidSchedulers
    ) {
    override fun execute(
        page: Int,
        description: String,
        location: String,
        callback: JobUseCase.Callback
    ) {
        jobRepository.getJobListing(description, location)
            .executeUseCaseObserveOnMainSubscribeOnIO(
                { callback.onGetJobsSuccess(it) },
                { callback.onGetJobsFailure(it) }
            )

    }
}