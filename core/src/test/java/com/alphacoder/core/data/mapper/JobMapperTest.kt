package com.alphacoder.core.data.mapper

import com.alphacoder.core.*
import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.domain.model.JobItem
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before


@RunWith(MockitoJUnitRunner::class)
class JobMapperTest{

    private lateinit var data: List<JobItem>
    lateinit var subject: JobMapper

    @Before
    fun setup(){
        subject = JobMapper()
    }

    @Test
    fun `whenOnMap thenJobItemResponsesMappedToJobItems`(){
        whenOnMap()
        thenJobItemResponsesMappedToJobItems()
    }

    /**
     * when
     */
    private fun whenOnMap() {
        data = (subject.map(SOME_JOB_RESPONSE_ITEMS) as ResultResponse.Success<List<JobItem>, Throwable>).data
    }


    /**
     * then
     */
    private fun thenJobItemResponsesMappedToJobItems() {
        assertThat(data[0].company).isEqualTo(SOME_COMPANY)
        assertThat(data[0].companyLogo).isEqualTo(SOME_COMPANY_LOGO)
        assertThat(data[0].companyUrl).isEqualTo(SOME_COMPANY_URL)
        assertThat(data[0].description).isEqualTo(SOME_DESCRIPTION)
        assertThat(data[0].howToApply).isEqualTo(SOME_HOW_TO_APPLY)
        assertThat(data[0].location).isEqualTo(SOME_LOCATION)
        assertThat(data[0].title).isEqualTo(SOME_TITLE)
        assertThat(data[0].type).isEqualTo(SOME_TYPE)
        assertThat(data[0].url).isEqualTo(SOME_URL)
    }
}