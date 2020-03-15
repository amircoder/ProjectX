package com.alphacoder.core

import com.alphacoder.core.base.ResultResponse
import com.alphacoder.core.data.model.job.JobItemResponse
import com.alphacoder.core.domain.model.JobItem
import java.util.*


/******************************************************
 * some dummy data used in unit tests
 ******************************************************/



/**
 * JobItemResponse
 */
const val SOME_URL = "SOME_URL"
const val SOME_TYPE = "SOME_TYPE"
const val SOME_TITLE = "SOME_TITLE"
const val SOME_ID = "SOME_ID"
const val SOME_HOW_TO_APPLY = "SOME_HOW_TO_APPLY"
const val SOME_CREATED_AT = "SOME_CREATED_AT"
const val SOME_COMPANY_URL = "SOME_COMPANY_URL"
const val SOME_COMPANY_LOGO = "SOME_COMPANY_LOGO"
const val SOME_COMPANY = "SOME_COMPANY"
const val SOME_DESCRIPTION = "SOME_DESCRIPTION"
const val SOME_LOCATION = "SOME_LOCATION"

const val SOME_OTHER_URL = "SOME_OTHER_URL"
const val SOME_OTHER_TYPE = "SOME_OTHER_TYPE"
const val SOME_OTHER_TITLE = "SOME_TOTHER_ITLE"
const val SOME_OTHER_ID = "SOME_OTHER_ID"
const val SOME_OTHER_HOW_TO_APPLY = "SOME_OTHER_HOW_TO_APPLY"
const val SOME_OTHER_CREATED_AT = "SOME_OTHER_CREATED_AT"
const val SOME_OTHER_COMPANY_URL = "SOME_OTHER_COMPANY_URL"
const val SOME_OTHER_COMPANY_LOGO = "SOME_OTHER_COMPANY_LOGO"
const val SOME_OTHER_COMPANY = "SOME_OTHER_COMPANY"
const val SOME_OTHER_DESCRIPTION = "SOME_OTHER_DESCRIPTION"
const val SOME_OTHER_LOCATION = "SOME_OTHER_LOCATION"

val SOME_JOB_RESPONSE = JobItemResponse().apply {
    company = SOME_COMPANY
    companyLogo = SOME_COMPANY_LOGO
    companyUrl = SOME_COMPANY_URL
    createdAt = SOME_CREATED_AT
    description = SOME_DESCRIPTION
    howToApply = SOME_HOW_TO_APPLY
    id = SOME_ID
    location = SOME_LOCATION
    title = SOME_TITLE
    type = SOME_TYPE
    url = SOME_URL
}

val SOME_OTHER_JOB_RESPONSE = JobItemResponse().apply {
    company = SOME_OTHER_COMPANY
    companyLogo = SOME_OTHER_COMPANY_LOGO
    companyUrl = SOME_OTHER_COMPANY_URL
    createdAt = SOME_OTHER_CREATED_AT
    description = SOME_OTHER_DESCRIPTION
    howToApply = SOME_OTHER_HOW_TO_APPLY
    id = SOME_OTHER_ID
    location = SOME_OTHER_LOCATION
    title = SOME_OTHER_TITLE
    type = SOME_OTHER_TYPE
    url = SOME_OTHER_URL
}

val SOME_JOB_RESPONSE_ITEMS: MutableList<JobItemResponse> = Collections.singletonList(SOME_JOB_RESPONSE)
val SOME_OTHER_JOB_RESPONSE_ITEMS = listOf(SOME_OTHER_JOB_RESPONSE)


/**
 * JobItem
 */

val SOME_JOB_ITEM = JobItem().apply {
    var company: String = SOME_COMPANY
    var companyLogo: String = SOME_COMPANY_LOGO
    var companyUrl: String = SOME_COMPANY_URL
    var description: String = SOME_DESCRIPTION
    var howToApply: String = SOME_HOW_TO_APPLY
    var location: String = SOME_LOCATION
    var title: String = SOME_TITLE
    var type: String = SOME_TYPE
    var url: String = SOME_URL
}
val SOME_JOB_ITEM_RESULT = listOf(SOME_JOB_ITEM)
val SOME_THROWABLE = Throwable("some throwable")
val mapResponse = ResultResponse.Success(SOME_JOB_ITEM_RESULT, SOME_THROWABLE)


/**
 * OTHER
 */
const val SOME_SEARCH_DESCRIPTION = "IOS"
const val SOME_SEARCH_LOCATION = "Germany"
const val SOME_DELAY = 1L
const val SOME_EMPTY_STRING = ""
const val SOME_PAGE = 1


