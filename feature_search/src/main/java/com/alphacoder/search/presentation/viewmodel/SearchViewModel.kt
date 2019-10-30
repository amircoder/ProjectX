package com.alphacoder.search.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alphacoder.core.base.BaseViewModel
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.domain.usecase.JobUseCase
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val jobUseCase: JobUseCase
) : BaseViewModel() {

    private var lastDescription = ""
    private var lastLocation = ""


    val jobLiveData = MutableLiveData<ResultResponse<List<JobItem>, Throwable>>()
    val pageLiveData = MutableLiveData<Int>().also {
        it.observeForever { page ->
            jobUseCase.execute(
                page,
                lastDescription,
                lastLocation,
                ::onGetJobSuccess,
                ::onGetJobFailed
            )
        }
    }

    fun getJob(
        description: String,
        location: String,
        page: Int = 1
    ) {
        lastDescription = description
        lastLocation = location
        pageLiveData.value = page
    }


    /**
     * Higher Order Functions
     */
    private fun onGetJobSuccess(result: ResultResponse<List<JobItem>, Throwable>) {
        Log.d("TestTag" , " response got")

        jobLiveData.postValue(result)
    }

    private fun onGetJobFailed(error: Throwable) {
        jobLiveData.postValue(ResultResponse.Failure(listOf(), error))

    }
}