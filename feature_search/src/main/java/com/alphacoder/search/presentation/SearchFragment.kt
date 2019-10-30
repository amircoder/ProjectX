package com.alphacoder.search.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.extension.observeLiveData
import com.alphacoder.core.view.ErrorSuccessFragment
import com.alphacoder.feature_search.R
import com.alphacoder.search.presentation.viewmodel.SearchViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.inc_search_bar.*
import kotlinx.android.synthetic.main.search_fragment.*
import javax.inject.Inject

class SearchFragment : ErrorSuccessFragment() {

    private companion object {
        const val DEFAULT_LOCATION = "usa"
    }

    private lateinit var viewModel: SearchViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.search_fragment, container, false)

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun initViewListeners() {
        submitSearchButton.setOnClickListener {
            lookUpForJobKeywordClick()
        }
    }

    override fun initObservers() {
        observeLiveData(viewModel.jobLiveData) { response ->
            renderJobData(response)
        }
    }

    private fun renderJobData(response: ResultResponse<List<JobItem>, Throwable>) {
        when (response) {
            is ResultResponse.Success<*, *> -> {
                hideLoadingSpinner()
            }
            is ResultResponse.Failure<*, *> -> {
                displayNetworkErrorMessage()
                hideLoadingSpinner()
            }
            is ResultResponse.Loading<*, *> -> {
                showLoadingSpinner()
            }
        }
    }

    private fun lookUpForJobKeywordClick() {
        viewModel.getJob(searchEditText.text.toString(), DEFAULT_LOCATION)
    }


}