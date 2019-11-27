package com.alphacoder.core.di

import com.alphacoder.core.rx.AppSchedulerProvider
import com.alphacoder.core.rx.SchedulerProvider
import com.twistedequations.rx2.AndroidRxSchedulers
import com.twistedequations.rx2.DefaultAndroidRxSchedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RxModule {
    @Singleton
    @Provides
    fun rxSchedulers() : AndroidRxSchedulers = DefaultAndroidRxSchedulers()

    @Singleton
    @Provides
    fun provideAppScheduler(rxSchedulers: AndroidRxSchedulers)
            : SchedulerProvider = AppSchedulerProvider(rxSchedulers)
}
