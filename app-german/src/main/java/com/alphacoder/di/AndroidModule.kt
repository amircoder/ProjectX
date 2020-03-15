package com.alphacoder.di

import android.app.Application
import com.alphacoder.config.GermanAppConfig
import com.alphacoder.core.AppConfig
import com.alphacoder.core.util.FragmentNavigationHelper
import com.alphacoder.navigation.GermanFragmentNavigationHelper
import com.alphacoder.theme.GermanAppThemeProvider
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
    fun providesThemeProvider(): ThemeProvider = GermanAppThemeProvider()

    @Provides
    @Singleton
    fun provideConfig(): AppConfig = GermanAppConfig()

    @Provides
    @Singleton
    fun provideFragmentNavigator(): FragmentNavigationHelper = GermanFragmentNavigationHelper()
}