package com.alphacoder.di

import com.twistedequations.rx2.AndroidRxSchedulers
import com.twistedequations.rx2.DefaultAndroidRxSchedulers
import dagger.Module
import dagger.Provides

@Module
class RxModule {
    @Provides
    fun rxSchedulers() : AndroidRxSchedulers = DefaultAndroidRxSchedulers()

}
