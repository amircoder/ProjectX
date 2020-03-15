package com.alphacoder.detail.di

import com.alphacoder.core.di.scopes.PerFragment
import com.alphacoder.detail.presentation.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailFragmentBinding {

    @PerFragment
    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun contributeDetailFragment(): DetailFragment
}