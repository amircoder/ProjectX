package com.alphacoder.core.di

import androidx.annotation.NonNull
import com.alphacoder.core.data.net.service.JobsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideJobService(
        @NonNull retrofit: Retrofit
    ): JobsService = retrofit.create(JobsService::class.java)

}