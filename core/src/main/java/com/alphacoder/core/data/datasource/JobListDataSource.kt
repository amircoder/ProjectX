package com.alphacoder.core.data.datasource


import com.alphacoder.core.base.BaseDatasource
import io.reactivex.Observable

interface JobListDataSource: BaseDatasource {

    fun getJobListing(description: String, location: String):
            Observable<List<JobItemResponse>>


}