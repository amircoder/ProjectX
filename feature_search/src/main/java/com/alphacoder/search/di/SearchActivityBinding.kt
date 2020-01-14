package com.alphacoder.search.di

import com.alphacoder.core.di.scopes.PerActivity
import com.alphacoder.search.presentation.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class SearchActivityBinding {

    @PerActivity
    @ContributesAndroidInjector(modules = [SearchActivityModule::class])
    abstract fun contributeSearchActivityModule(): SearchActivity



}