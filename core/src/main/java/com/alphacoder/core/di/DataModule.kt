package com.alphacoder.core.di


import com.alphacoder.core.data.datasource.local.dao.JobDao
import com.alphacoder.core.data.datasource.remote.JobListRemoteDataSource
import com.alphacoder.core.data.datasource.remote.JobListRemoteDataSourceImpl
import com.alphacoder.core.data.mapper.JobMapper
import com.alphacoder.core.data.net.service.JobsService
import com.alphacoder.core.data.repository.JobRepositoryImpl
import com.alphacoder.core.domain.repository.JobRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideJobRepository(
        remoteDataSource: JobListRemoteDataSource,
        dao: JobDao,
        mapper: JobMapper
    ): JobRepository = JobRepositoryImpl(remoteDataSource, dao, mapper)

    @Provides
    @Singleton
    fun provideJobRemoteDataSource(
        service: JobsService
    ): JobListRemoteDataSource = JobListRemoteDataSourceImpl(service)

    @Provides
    @Singleton
    fun provideJobMapper(): JobMapper = JobMapper()



}