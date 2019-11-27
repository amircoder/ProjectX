package com.alphacoder.search.di


import com.alphacoder.search.presentation.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchActivityModule {

    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    abstract fun ContributeSearchFragment(): SearchFragment

}
