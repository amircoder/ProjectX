package com.alphacoder.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alphacoder.core.di.ViewModelKey
import com.alphacoder.core.factory.AppViewModelFactory
import com.alphacoder.search.presentation.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory : AppViewModelFactory) : ViewModelProvider.Factory
}
