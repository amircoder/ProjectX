package com.alphacoder.core.data.local

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.alphacoder.core.SOME_DESCRIPTION
import com.alphacoder.core.SOME_JOB_RESPONSE_ITEMS
import com.alphacoder.core.SOME_LOCATION
import com.alphacoder.core.data.datasource.local.dao.JobDao
import com.alphacoder.core.data.db.AppDatabase
import com.alphacoder.core.data.model.job.JobItemResponse
import io.reactivex.observers.TestObserver
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JobDaoTestXd{

    private lateinit var database: AppDatabase
    private lateinit var jobDao: JobDao

//    @Rule
//    private val testRule = RxImmediateSchedulerRule()

    private val testObserver = TestObserver<List<JobItemResponse>>()

    @Before
    fun setup(){
        database = AppDatabase.getTestInstance(InstrumentationRegistry.getInstrumentation().targetContext)
        jobDao = database.jobDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun whenJobInserted_andWhenGetJobs_givenDescriptionAndLocationStrings_thenJobIsInserted(){
        whenJobInserted()
        whenGetJobs()
        thenJobIsInserted()
    }


    /*
     * when
     */
    private fun whenJobInserted() {
        jobDao.insertOrUpdate(SOME_JOB_RESPONSE_ITEMS)

    }

    private fun whenGetJobs() {
        jobDao.getJobListing(SOME_DESCRIPTION, SOME_LOCATION)
            .subscribe(testObserver)

    }


    /*
     * then
     */
    private fun thenJobIsInserted() {
        testObserver.assertValues(SOME_JOB_RESPONSE_ITEMS)
    }
}