package com.alphacoder.search.di

import com.alphacoder.search.presentation.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class SearchActivityBinding {

    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    abstract fun contributeSearchActivityModule(): SearchActivity

}