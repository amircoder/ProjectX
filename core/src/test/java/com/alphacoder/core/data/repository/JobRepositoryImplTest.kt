package com.alphacoder.core.data.repository

import com.alphacoder.core.*
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.data.datasource.local.JobListLocalDataSource
import com.alphacoder.core.data.datasource.remote.JobListRemoteDataSource
import com.alphacoder.core.data.mapper.JobMapper
import com.alphacoder.core.domain.model.JobItem
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.then
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class JobRepositoryImplTestX {

    @Mock
    lateinit var mockRemoteDataSource: JobListRemoteDataSource
    @Mock
    lateinit var mockLocalDataSource: JobListLocalDataSource
    @Mock
    lateinit var mapper: JobMapper
    @InjectMocks
    lateinit var subject: JobRepositoryImpl

    private val testObserver = TestObserver<ResultResponse<List<JobItem>, Throwable>>()


    @Before
    fun setup() {
        givenMapperOutputIsSuccessful()
    }

    @Test
    fun `whenOnGetGetJobListing givenRemoteDataIsAvailable andGivenLocalDataIsAvailable thenRemoteDataSourceGetJobListingCalled andThenLocalDataSourceGetJobListingCalled`() {
        givenLocalResponseIsSuccess()
        givenRemoteResponseIsSuccess()
        whenOnGetGetJobListing()
        thenRemoteDataSourceGetJobListingCalled()
        thenLocalDataSourceGetJobListingCalle()
        thenResultIsSuccessful()
    }


    /**
     * GIVEN
     */
    private fun givenRemoteResponseIsSuccess() {
        given(mockRemoteDataSource.getJobListing(SOME_DESCRIPTION, SOME_LOCATION))
            .willReturn(Observable.just(SOME_JOB_RESPONSE_ITEMS))
    }

    private fun givenLocalResponseIsSuccess() {
        given(mockLocalDataSource.getJobListing(SOME_DESCRIPTION, SOME_LOCATION))
            .willReturn(Observable.just(SOME_OTHER_JOB_RESPONSE_ITEMS))
    }

    private fun givenMapperOutputIsSuccessful() {
        given(mapper.map(SOME_JOB_RESPONSE_ITEMS)).willReturn(
            mapResponse
        )

        given(mapper.map(SOME_OTHER_JOB_RESPONSE_ITEMS)).willReturn(
            mapResponse
        )
    }


    /**
     * WHEN
     */
    private fun whenOnGetGetJobListing() {
        subject.getJobListing(
            SOME_DESCRIPTION,
            SOME_LOCATION
        ).subscribe(testObserver)
    }


    /**
     * THEN
     */
    private fun thenLocalDataSourceGetJobListingCalle() {
        then(mockLocalDataSource).should().getJobListing(SOME_DESCRIPTION, SOME_LOCATION)
    }

    private fun thenRemoteDataSourceGetJobListingCalled() {
        then(mockRemoteDataSource).should().getJobListing(SOME_DESCRIPTION, SOME_LOCATION)
    }

    private fun thenResultIsSuccessful() {
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValues(mapResponse, mapResponse)
    }

    /**
     * Helpers
     */


}