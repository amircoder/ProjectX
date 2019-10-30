package com.alphacoder.search.di


import com.alphacoder.search.presentation.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchFragmentModule {

    @ContributesAndroidInjector
    abstract fun ContributeSearchFragment(): SearchFragment

}
