package com.alphacoder.core.data.datasource.remote

import com.alphacoder.core.*
import com.alphacoder.core.data.model.job.JobItemResponse
import com.alphacoder.core.data.net.service.JobsService
import com.alphacoder.core.domain.model.JobItem
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.then
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class JobListRemoteDataSourceImplTest {

    @Mock
    private lateinit var mockService: JobsService

    @InjectMocks
    private lateinit var subject: JobListRemoteDataSourceImpl

    private val testObserver = TestObserver<List<JobItemResponse>>()


    private lateinit var location: String



    @Test
    fun `whenGetJobListing givenLocationStringAvailable andGivenJobResponseSuccessful thenServiceGetJobCalled andThenResponseIsAvailable`() {
        givenLocationStringAvailable()
        givenJobResponseSuccessful()
        whenGetJobListing()
        thenServiceGetJobCalled()
        thenResponseIsAvailable()
    }

    @Test
    fun `whenGetJobListing givenLocationStringIsEmpty andGivenJobResponseSuccessful thenServiceGetJobCalled andThenResponseIsAvailable`() {
        givenLocationStringIsEmpty()
        givenJobResponseSuccessful()
        whenGetJobListing()
        thenServiceGetJobCalledWithoutLocation()
        thenResponseIsAvailable()
    }


    /**
     * given
     */
    private fun givenLocationStringAvailable() {
        location = SOME_LOCATION
    }

    private fun givenLocationStringIsEmpty() {
        location = SOME_EMPTY_STRING
    }

    private fun givenJobResponseSuccessful() {

        given(mockService.getJobs(SOME_DESCRIPTION, location))
            .willReturn(Observable.just(SOME_JOB_RESPONSE_ITEMS))

        given(mockService.getJobs(SOME_DESCRIPTION))
            .willReturn(Observable.just(SOME_JOB_RESPONSE_ITEMS))
    }


    /**
     * when
     */
    private fun whenGetJobListing() {
        subject.getJobListing(SOME_DESCRIPTION, location).subscribe(testObserver)
    }


    /**
     * then
     */
    private fun thenServiceGetJobCalled() {
        then(mockService).should().getJobs(SOME_DESCRIPTION, location)
    }

    private fun thenServiceGetJobCalledWithoutLocation() {
        mockService.getJobs(SOME_DESCRIPTION)
    }

    private fun thenResponseIsAvailable() {
        testObserver.assertNoErrors()
        testObserver.assertValues(SOME_JOB_RESPONSE_ITEMS)
        testObserver.assertComplete()
    }
}