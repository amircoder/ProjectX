package com.alphacoder.core.domain.usecase

import com.alphacoder.core.*
import com.alphacoder.core.domain.model.JobItem
import com.alphacoder.core.domain.repository.JobRepository
import com.alphacoder.core.rx.TestSchedulerProvider
import com.alphacoder.core.rx.TrampolineSchedulerProvider
import com.nhaarman.mockitokotlin2.then
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.times
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.TimeUnit

@RunWith(MockitoJUnitRunner::class)
class JobUseCaseImplTestXC {

    private lateinit var result: List<JobItem>
    @Mock
    lateinit var mockRepository: JobRepository
    @Mock
    lateinit var mockCallback: JobUseCase.Callback

    private lateinit var subject: JobUseCaseImpl

    @Suppress("unused")
    @Spy
    private val trampolineSchedulerProvider = TrampolineSchedulerProvider()

    private val testSchedulerProvider = TestSchedulerProvider()

    private val testObserver = TestObserver<List<JobItem>>()

    @Before
    fun setup() {
        instantiateWithTrampolineScheduler()
    }


    @Test
    fun `whenOnExecute givenJobRepositoryResponseSuccessful thenJobRepositoryGetJobListingCalled andThenResponseIsAvailable`() {
        givenJobRepositoryResponseSuccessful()
        whenOnExecute()
        thenJobRepositoryGetJobListingCalled()
        thenCallbackOnGetJobsSuccessCalled()
    }

    @Test
    fun `whenOnExecute givenJobRepositoryResponseError thenJobRepositoryGetJobListingCalled andThenResponseIsAvailable`() {
        givenJobRepositoryResponseError()
        whenOnExecute()
        thenJobRepositoryGetJobListingCalled()
        thenCallbackOnGetJobsFailureCalled()
    }


    /*
     * given
     */
    private fun givenJobRepositoryResponseSuccessful() {
        given(mockRepository.getJobListing(SOME_DESCRIPTION, SOME_LOCATION))
            .willReturn(Observable.just(mapResponse))
    }

    private fun givenJobRepositoryResponseError() {
        given(mockRepository.getJobListing(SOME_DESCRIPTION, SOME_LOCATION))
            .willReturn(Observable.error(SOME_THROWABLE))
    }


    /*
     * when
     */
    private fun whenOnExecute() {
        subject.execute(SOME_PAGE, SOME_DESCRIPTION, SOME_LOCATION, mockCallback)
    }


    /*
     * then
     */
    private fun thenJobRepositoryGetJobListingCalled() {
        then(mockRepository).should().getJobListing(SOME_DESCRIPTION, SOME_LOCATION)
    }

    private fun thenCallbackOnGetJobsSuccessCalled() {
        then(mockCallback).should(times(1)).onGetJobsSuccess(mapResponse)
    }

    private fun thenCallbackOnGetJobsFailureCalled() {
        then(mockCallback).should().onGetJobsFailure(SOME_THROWABLE)
    }

    /*
     * helper
     */
    private fun instantiateWithTrampolineScheduler() {
        subject = JobUseCaseImpl(mockRepository, trampolineSchedulerProvider)
    }

    private fun instantiateWithTestScheduler() {
        subject = JobUseCaseImpl(mockRepository, testSchedulerProvider)
    }

    private fun advanceTime(time: Long) {
        testSchedulerProvider.testScheduler.triggerActions()
        testSchedulerProvider.testScheduler.advanceTimeBy(time, TimeUnit.SECONDS)
    }



}