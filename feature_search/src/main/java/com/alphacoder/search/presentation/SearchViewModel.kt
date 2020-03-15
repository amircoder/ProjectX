package com.alphacoder.search.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alphacoder.core.AppConstant.SEARCH_SEPARATOR
import com.alphacoder.core.base.BaseViewModel
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.domain.usecase.JobUseCase
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val jobUseCase: JobUseCase
) : BaseViewModel(), JobUseCase.Callback {

    val jobLiveData: LiveData<ResultResponse<List<JobItem>, Throwable>>
        get() = _jobLiveData

    private var _lastDescription = ""
    private var _lastLocation = ""
    private val _jobLiveData = MutableLiveData<ResultResponse<List<JobItem>, Throwable>>()
    private val _pageLiveData = MutableLiveData<Int>().also {
        it.observeForever { page ->
            jobUseCase.execute(
                page,
                _lastDescription,
                _lastLocation,
                this
            )
        }
    }

    fun getJob(
        searchInput: String,
        page: Int = 1
    ) {
        // separating job description and job location
        if (searchInput.contains(SEARCH_SEPARATOR)) {
            _lastDescription = findDescriptionFromSearchString(searchInput)
            _lastLocation = findLocationFromSearchString(searchInput)
            _pageLiveData.postValue(page)
        } else {
            _lastDescription = searchInput.trim()
            _lastLocation = ""
            _pageLiveData.postValue(page)
        }
    }


    /**
     * Callback Functions
     */
    override fun onGetJobsFailure(error: Throwable) {
        _jobLiveData.postValue(ResultResponse.Failure(listOf(), error))
    }

    override fun onGetJobsSuccess(data: ResultResponse<List<JobItem>, Throwable>) {
        _jobLiveData.postValue(data)
    }


    /**
     * Helper functions
     */
    private fun findDescriptionFromSearchString(input: String) =
        input.substring(0, input.indexOf(SEARCH_SEPARATOR)).trim()

    private fun findLocationFromSearchString(input: String) =
        input.substring(input.indexOf(SEARCH_SEPARATOR) + 1).trim()

}