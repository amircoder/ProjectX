package com.alphacoder.core.domain.usecase

import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.base.UseCase
import com.alphacoder.core.domain.model.JobItem


interface JobUseCase: UseCase<ResultResponse<List<JobItem>, Throwable>, List<JobItem>, Throwable> {
    fun execute(page: Int,
                description: String,
                location: String,
                onSuccess: (ResultResponse<List<JobItem>, Throwable>) -> Unit,
                onFailure: (Throwable) -> Unit)
}