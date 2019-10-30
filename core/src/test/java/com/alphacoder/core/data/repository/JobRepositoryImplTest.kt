package com.alphacoder.core.data.repository

import com.alphacoder.core.*
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.data.datasource.local.JobListLocalDataSource
import com.alphacoder.core.data.datasource.remote.JobListRemoteDataSource
import com.alphacoder.core.data.mapper.JobMapper
import com.alphacoder.core.domain.model.JobItem
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins




@RunWith(MockitoJUnitRunner::class)
class JobRepositoryImplTest {

    @Mock
    lateinit var remoteDataSource: JobListRemoteDataSource
    @Mock
    lateinit var localDataSource: JobListLocalDataSource
    @Mock
    lateinit var mapper: JobMapper
    @InjectMocks
    lateinit var subject: JobRepositoryImpl

    private lateinit var result: Observable<ResultResponse<List<JobItem>, Throwable>>
    private val testResponse = ResultResponse.Success(SOME_JOB_ITEM_RESULT, Throwable())
    private val testObserver = TestObserver<ResultResponse<List<JobItem>, Throwable>>()


    @Before
    fun setup() {
        givenMapperOutputIsSuccessful()
    }


//    private fun setUpUsingTestSchedulers() {
//        subject = JobRepositoryImpl(
//            remoteDataSource,
//            localDataSource, mapper
//        )
//    }

//    private fun setUpUsingImmediateSchedulers() {
//        subject = JobRepositoryImpl(
//            remoteDataSource,
//            localDataSource, immediateSchedulerProvider
//        )
//    }


    @Test
    fun whenOnGetGetJobListing_givenRemoteDataIsAvailable_andGivenLocalDataIsAvailable_thenResponseIsSuccessful() {
        givenLocalResponseIsSuccess()
        givenRemoteResponseIsSuccess()
        whenOnGetGetJobListing()
        thenResponseIsSuccessful()
    }


    /**
     * GIVEN
     */
    private fun givenRemoteResponseIsSuccess() {
        given(remoteDataSource.getJobListing(anyString(), anyString()))
            .willReturn(Observable.just(SOME_JOB_RESPONSE_TEMS))
    }

    private fun givenLocalResponseIsSuccess() {
        given(localDataSource.getJobListing())
            .willReturn(Observable.just(SOME_OTHER_JOB_RESPONSE_TEMS))
    }

    private fun givenMapperOutputIsSuccessful() {
        given(mapper.map(any())).willReturn(ResultResponse.Success(SOME_JOB_ITEM_RESULT, Throwable()))
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
    private fun thenResponseIsSuccessful() {
        testObserver.assertComplete()
        testObserver.assertValue(testResponse)

    }


    /**
     * Helpers
     */


}