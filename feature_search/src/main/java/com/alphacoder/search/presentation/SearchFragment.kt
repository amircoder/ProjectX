package com.alphacoder.search.presentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.data.net.service.JobsService
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.extension.*
import com.alphacoder.core.util.UIUtils
import com.alphacoder.core.view.ErrorSuccessFragment
import com.alphacoder.feature_search.R
import com.alphacoder.search.presentation.list.SearchListAdapter
import com.alphacoder.search.presentation.list.SearchListAdapterImpl
import com.twistedequations.rx2.AndroidRxSchedulers
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.inc_empty_search.*
import kotlinx.android.synthetic.main.inc_search_bar.*
import kotlinx.android.synthetic.main.inc_search_button.*
import kotlinx.android.synthetic.main.inc_search_list.*
import javax.inject.Inject

class SearchFragment : ErrorSuccessFragment(), SearchListAdapter.Callback {

    private lateinit var viewModel: SearchViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var service: JobsService
    @Inject
    lateinit var rxSchedulers: AndroidRxSchedulers

    @Inject
    lateinit var searchAdapter: SearchListAdapter

    override fun onJobItemClicked(jobItem: JobItem) {
        // TODO: WFP(?)
    }

    /**
     * public functions
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.search_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        displayEmptyBadge(true)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
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
                displayNetworkErrorMessage()
                processError(response.throwable ?: Throwable("no error found"))
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
        if (list.isEmpty()){
            displayEmptyBadge(true)
        }else  {
            displayEmptyBadge(false)
            searchAdapter.listItems = list
        }
    }

    private fun searchJob() {
        if (checkSearchInput()){
            viewModel.getJob(searchEditText.text.toString())
            UIUtils.closeKeyboard(activity as Activity)
        }else {
            getString(R.string.fill_neccessary_fields_and_try_again)
                .displayShortToast(context!!)
        }
    }

    private fun checkSearchInput() = searchEditText.text.isNotEmpty()

    private fun setupRecyclerView() {
        with(searchJobListingRecyclerView) {
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(requireContext())
            hasFixedSize()
        }
    }

    private fun displayEmptyBadge(display: Boolean) {
        if (display){
            emptySearchLayout.show()
            searchJobListingRecyclerView.hide()
        }else {
            emptySearchLayout.hide()
            searchJobListingRecyclerView.show()
        }
    }
}