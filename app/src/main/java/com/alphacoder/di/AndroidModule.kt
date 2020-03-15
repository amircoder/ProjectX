package com.alphacoder.di

import android.app.Application
import com.alphacoder.config.GlobalAppConfig
import com.alphacoder.core.AppConfig
import com.alphacoder.core.util.FragmentNavigationHelper
import com.alphacoder.navigation.AppFragmentNavigationHelper
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

    @Provides
    @Singleton
    fun provideConfig(): AppConfig = GlobalAppConfig()

    @Provides
    @Singleton
    fun provideFragmentNavigator(): FragmentNavigationHelper = AppFragmentNavigationHelper()

}
