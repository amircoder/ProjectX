package com.alphacoder.core.di

import com.alphacoder.core.domain.repository.JobRepository
import com.alphacoder.core.domain.usecase.JobUseCase
import com.alphacoder.core.domain.usecase.JobUseCaseImpl
import com.twistedequations.rx2.AndroidRxSchedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideJobUseCase(
        jobRepository: JobRepository,
        schedulers: AndroidRxSchedulers
    ): JobUseCase = JobUseCaseImpl(
        jobRepository,
        schedulers
    )

}