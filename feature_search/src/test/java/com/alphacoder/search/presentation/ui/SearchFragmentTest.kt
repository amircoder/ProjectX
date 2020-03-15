package com.alphacoder.search.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.alphacoder.core.*
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.rx.SchedulerProvider
import com.alphacoder.core.rx.TestSchedulerProvider
import com.alphacoder.core.rx.TrampolineSchedulerProvider
import com.alphacoder.feature_search.R
import com.alphacoder.search.presentation.SearchFragment
import com.alphacoder.search.presentation.SearchViewModel
import com.alphacoder.search.presentation.list.SearchListAdapter
import com.nhaarman.mockitokotlin2.*
import junit.framework.Assert.assertTrue
import kotlinx.android.synthetic.main.inc_empty_search.*
import kotlinx.android.synthetic.main.inc_search_bar.*
import kotlinx.android.synthetic.main.inc_search_button.*
import kotlinx.android.synthetic.main.inc_search_list.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.android.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.MockitoAnnotations.initMocks
import org.robolectric.shadows.ShadowToast

class SearchFragmentTest : FragmentTestBase<SearchFragment>() {

    private var mockViewModel: SearchViewModel = mock()
    private var mockViewModelFactory: ViewModelProvider.Factory = mock()
    private var mockSearchAdapter: SearchListAdapter = mock()
    private var appConfig: AppConfig = mock()

    private var jobLiveData = MutableLiveData<ResultResponse<List<JobItem>, Throwable>>()
    private lateinit var viewModel: SearchViewModel
    private lateinit var testSchedulers: SchedulerProvider
    private lateinit var spyFragment: SearchFragment

    private lateinit var result: ResultResponse<List<JobItem>, Throwable>

    private val recyclerView: RecyclerView by lazy {
        fragment.searchJobListingRecyclerView
    }

    @Before
    fun setup() {
        createImmediateScheduler()
        initMocks(this)
        givenViewModelProviderThenCreateViewModel()
        givenJobLiveDataWillReturnActualLiveData()
        givenAppConfigLocationAvailable()
        createFragment()
        viewModel = spy(fragment.viewModel)
        spyFragment = spy(fragment)
    }


    @Test
    fun `whenOnCreate thenViewIsCreatedAndVisible andThenViewModelCreated`() {
        thenViewIsCreatedAndVisible()
        thenViewModelCreated()
    }


    @Test
    fun `whenOnViewCreated thenSetupRecyclerView AndThenDisplayEmptyBadge AndThenViewListenersIsSet`() {
        thenSetupRecyclerView()
        thenDisplayEmptyBadge()
        thenViewListenersIsSet()
    }

    @Test
    fun `whenOnViewCreated givenAppConfigLocationAvailable thenSetEditTextString`() {
        thenSetEditTextHintString()
    }


    @Test
    fun `whenOnErrorAction givenSearchEditTextIsNotEmpty thenViewModelSearchForJobCalled`() {
        givenSearchEditTextIsNotEmpty()
        whenOnErrorAction()
        thenViewModelSearchForJobCalled()
    }

    @Test
    fun `whenOnErrorAction givenSearchEditTextIsEmpty thenDisplayToast`() {
        givenSearchEditTextIsEmpty()
        whenOnErrorAction()
        thenDisplayToast(getString(R.string.fill_neccessary_fields_and_try_again))
    }

    @Ignore
    @Test
    fun `whenLiveDataOnChanged  givenSuccessResult thenRecyclerViewAdapterIsPopulated`() {
        givenSuccessResult()
        whenLiveDataOnChanged()
        thenRecyclerViewAdapterIsPopulated()
        thenRecyclerAdapterShouldNotifyDataSetChanged()
    }

    @Ignore
    @Test
    fun `whenLiveDataOnChanged givenErrorResult thenDisplayErrorMessage andThenHideLoadingSpinner`() {
        givenSuccessError()
        whenLiveDataOnChanged()
        thenDisplayErrorMessage()
        thenHideLoader()
    }

    @Ignore
    @Test
    fun `whenLiveDataOnChanged givenLoadingResult thenShowLoading`() {
        givenLoadingResult()
        whenLiveDataOnChanged()
        thenShowLoader()
    }


    /*
     GIVEN
    */
    private fun givenJobLiveDataWillReturnActualLiveData() {
        given(mockViewModel.jobLiveData).willReturn(jobLiveData)
    }

    private fun givenViewModelProviderThenCreateViewModel() {
        given(mockViewModelFactory.create(SearchViewModel::class.java)).willReturn(mockViewModel)
    }

    private fun givenAppConfigLocationAvailable() {
        given(appConfig.location).willReturn(SOME_LOCATION)
    }

    private fun givenSearchEditTextIsNotEmpty() {
        fragment.searchEditText.setText(SOME_TITLE)
    }

    private fun givenSearchEditTextIsEmpty() {
        fragment.searchEditText.setText(SOME_EMPTY_STRING)
    }

    private fun givenSuccessResult() {
        result = ResultResponse.Success(SOME_JOB_ITEM_RESULT, Throwable(""))
    }

    private fun givenSuccessError() {
        result = ResultResponse.Failure(listOf(), Throwable(""))
    }

    private fun givenLoadingResult() {
        result = ResultResponse.Loading()
    }

    /*
     WHEN
     */
    private fun whenOnErrorAction() {
        fragment.onErrorAction()
    }

    private fun whenLiveDataOnChanged() {
        jobLiveData.postValue(result)
    }

    private fun whenOnJobItemClicked() {
        fragment.onJobItemClicked(SOME_JOB_ITEM)
    }


    /*
     THEN
     */
    private fun thenViewIsCreatedAndVisible() {
        assertThat(fragment.view).isNotNull
        assertThat(fragment.view).isVisible
    }

    private fun thenViewModelCreated() {
        assertThat(viewModel).isNotNull
    }

    private fun thenSetupRecyclerView() {
        with(recyclerView) {
            assertThat(layoutManager).isNotNull
            assertThat(adapter).isEqualTo(mockSearchAdapter)
        }
    }

    private fun thenDisplayEmptyBadge() {
        assertThat(recyclerView).isNotVisible
        assertThat(fragment.emptySearchLayout).isVisible
    }

    private fun thenViewModelSearchForJobCalled() {
        then(mockViewModel).should().getJob(SOME_TITLE)
    }

    private fun thenSetEditTextHintString() {
        assertThat(fragment.searchEditText.hint.toString())
            .isEqualTo(getString(R.string.search_hint).format(appConfig.location))
    }

    private fun thenDisplayToast(msg: String) {
        ShadowToast.showedToast(msg)
    }

    private fun thenViewListenersIsSet() {
        assertTrue(fragment.submitSearchButton.hasOnClickListeners())
    }

    private fun thenRecyclerViewAdapterIsPopulated() {
        then(mockSearchAdapter).should().listItems = SOME_JOB_ITEM_RESULT
    }

    private fun thenRecyclerAdapterShouldNotifyDataSetChanged() {
        then(mockSearchAdapter).should().notifyDataSetChanged()
    }

    private fun thenDisplayErrorMessage() {
        then(fragment).should().displayCustomError(any(), any())
    }

    private fun thenHideLoader() {
        then(fragment).should().hideLoadingSpinner()
    }

    private fun thenShowLoader() {
        then(fragment).should().showLoadingSpinner()
    }


    /*
     HELPER
     */

    private fun createImmediateScheduler() {
        testSchedulers = TrampolineSchedulerProvider()
    }

    private fun createTestScheduler() {
        testSchedulers = TestSchedulerProvider()
    }


}