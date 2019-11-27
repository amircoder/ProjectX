package com.alphacoder.search.di

import com.alphacoder.search.presentation.SearchFragment
import com.alphacoder.search.presentation.list.SearchListAdapter
import com.alphacoder.search.presentation.list.SearchListAdapterImpl
import dagger.Module
import dagger.Provides

@Module
class SearchFragmentModule {

    @Provides
    fun provideSearchRecyclerAdapter(adapter: SearchListAdapterImpl)
            : SearchListAdapter = adapter

    @Provides
    fun provideSearchAdapterCallback(fragment: SearchFragment)
            : SearchListAdapter.Callback = fragment


}
