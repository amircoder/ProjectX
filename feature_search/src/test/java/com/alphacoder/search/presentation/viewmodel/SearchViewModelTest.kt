package com.alphacoder.search.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.domain.usecase.JobUseCase
import com.alphacoder.core.util.test.TestableViewObserver
import com.alphacoder.search.presentation.SearchViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.then
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner



@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {
    companion object {
        const val SOME_SEARCH_DESCRIPTION = "IOS"
        const val SOME_SEARCH_LOCATION = "Germany"
        const val SOME_PAGE = 1

        const val SOME_SEARCH_STRING_WITH_DESCRIPTION_AND_LOCATION =
            "$SOME_SEARCH_DESCRIPTION @ $SOME_SEARCH_LOCATION"

    }

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var mockUseCaseImpl: JobUseCase

    private lateinit var subject: SearchViewModel

    private val observer:
            TestableViewObserver<ResultResponse<List<JobItem>, Throwable>> = mock()

    @Before
    fun setup() {
        subject = SearchViewModel(mockUseCaseImpl)
        subject.jobLiveData.observeForever(observer)
    }

    @Test
    fun `whenOnGetJob thenJobUseCaseExecuted`() {
        whenOnGetJob()
        thenJobUseCaseExecuteCalled()
    }


    /*
     * when
     */
    private fun whenOnGetJob() {
        subject.getJob(SOME_SEARCH_STRING_WITH_DESCRIPTION_AND_LOCATION)
    }

    /*
     * then
     */
    private fun thenJobUseCaseExecuteCalled() {
        then(mockUseCaseImpl).should().execute(
            SOME_PAGE,
            SOME_SEARCH_DESCRIPTION,
            SOME_SEARCH_LOCATION,
            subject
        )
    }


}