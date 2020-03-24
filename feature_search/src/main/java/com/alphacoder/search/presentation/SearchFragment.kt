package com.alphacoder.search.presentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alphacoder.core.AppConfig
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.extension.*
import com.alphacoder.core.util.UIUtils
import com.alphacoder.core.view.ErrorSuccessFragment
import com.alphacoder.feature_search.R
import com.alphacoder.search.presentation.list.SearchListAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.inc_empty_search.*
import kotlinx.android.synthetic.main.inc_search_bar.*
import kotlinx.android.synthetic.main.inc_search_button.*
import kotlinx.android.synthetic.main.inc_search_list.*
import javax.inject.Inject

class SearchFragment : ErrorSuccessFragment(), SearchListAdapter.Callback {

    @VisibleForTesting
    lateinit var viewModel: SearchViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var appConfig: AppConfig
    @Inject
    lateinit var searchAdapter: SearchListAdapter

    override val contentResourceId = R.layout.search_fragment

    /**
     * Callback functions
     */
    override fun onJobItemClicked(jobItem: JobItem) {
        navigate(R.id.errorContentContainer, fragmentNavigator.getDetailFragment(jobItem.id), jobItem.title )
    }

    /**
     * public functions
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SearchViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayEmptyBadge(true)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun setupView() {
        searchEditText.hint = getString(R.string.search_hint).format(appConfig.location)
    }

    override fun initViewListeners() {
        submitSearchButton.setOnClickListener {
            searchJob()
        }

        searchJobListingRecyclerView.setOnScrollDirectionListener(
            { submitSearchButton.hide() },
            { submitSearchButton.show() })
    }


    override fun initObservers() {
        observeLiveData(viewModel.jobLiveData) { response ->
            renderJobData(response)
        }
    }

    override fun setupRecyclerView() {
        with(searchJobListingRecyclerView) {
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(requireContext())
            hasFixedSize()
        }
    }

    override fun onErrorAction() {
        super.onErrorAction()
        searchJob()
    }

    private fun renderJobData(response: ResultResponse<List<JobItem>, Throwable>) {

        when (response) {
            is ResultResponse.Success<*, *> -> {
                processSuccessResult(response.data as List<JobItem>)
                hideLoadingSpinner()
            }
            is ResultResponse.Failure<*, *> -> {
                processError(response.throwable ?: Throwable())
                hideLoadingSpinner()
            }
            is ResultResponse.Loading<*, *> -> {
                showLoadingSpinner()
            }
            else -> {
                hideLoadingSpinner()
            }
        }
    }


    /**
     * private methods
     */

    private fun processError(error: Throwable) {
        displayCustomError("error", error.toString())
    }

    private fun processSuccessResult(list: List<JobItem>) {
        if (list.isEmpty()) {
            displayEmptyBadge(true)
        } else {
            displayEmptyBadge(false)
            searchAdapter.listItems = list
        }
    }

    private fun searchJob() {
        if (checkSearchInput()) {
            viewModel.getJob(searchEditText.text.toString())
            UIUtils.closeKeyboard(activity as Activity)
        } else {
            getString(R.string.fill_neccessary_fields_and_try_again)
                .displayShortToast(context!!)
        }
    }

    private fun checkSearchInput() = searchEditText.text.isNotEmpty()

    private fun displayEmptyBadge(display: Boolean) {

        if (display) {
            emptySearchLayout.show()
            searchJobListingRecyclerView.hide()
        } else {
            emptySearchLayout.hide()
            searchJobListingRecyclerView.show()
        }
    }
}