package com.alphacoder.core.domain.usecase

import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.UseCase
import com.alphacoder.core.domain.model.JobItem


interface JobUseCase:
    UseCase<ResultResponse<List<JobItem>, Throwable>, List<JobItem>, Throwable> {
    fun execute(page: Int,
                description: String,
                location: String,
                callback: Callback)


    /*
    Prefer using callbacks instead of higher order functions for easier testability
     */
    interface Callback {
        fun onGetJobsSuccess(data: ResultResponse<List<JobItem>, Throwable>)
        fun onGetJobsFailure(throwable: Throwable)
    }
}