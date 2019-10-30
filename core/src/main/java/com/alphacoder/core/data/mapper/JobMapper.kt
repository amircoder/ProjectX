package com.alphacoder.core.data.mapper



import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.data.model.job.JobItemResponse
import com.alphacoder.core.domain.model.JobItem
import javax.inject.Inject

class JobMapper @Inject constructor() {

    fun map(jobItemResponses: List<JobItemResponse>): ResultResponse<List<JobItem>, Throwable> {
        val jobItems = mutableListOf<JobItem>()
        with(jobItems) {
            jobItemResponses.map { item ->
                add(
                    JobItem(
                        item.company,
                        item.companyLogo,
                        item.companyUrl ?: "",
                        item.description,
                        item.howToApply,
                        item.location ?: "",
                        item.title,
                        item.type,
                        item.url
                    )
                )
            }
        }

        return ResultResponse.Success(jobItems, Throwable())
    }
}