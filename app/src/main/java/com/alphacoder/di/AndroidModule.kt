package com.alphacoder.di

import android.app.Application
import com.alphacoder.theme.AppThemeProvider
import com.alphacoder.view.ThemeProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule {
    @Provides
    @Singleton
    fun provideContext(application: Application) = application.applicationContext

    @Provides
    @Singleton
    fun providesThemeProvider(): ThemeProvider = AppThemeProvider()
}
