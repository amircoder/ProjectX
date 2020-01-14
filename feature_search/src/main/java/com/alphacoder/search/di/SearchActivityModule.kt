package com.alphacoder.search.di


import com.alphacoder.core.di.scopes.PerFragment
import com.alphacoder.search.presentation.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    abstract fun ContributeSearchFragment(): SearchFragment

}
