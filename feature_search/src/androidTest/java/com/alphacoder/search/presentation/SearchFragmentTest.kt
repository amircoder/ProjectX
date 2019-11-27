package com.alphacoder.search.presentation

import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.alphacoder.core.data.base.FragmentTestBase
import com.alphacoder.search.presentation.list.SearchListAdapter
import junit.framework.Assert.*
import kotlinx.android.synthetic.main.inc_empty_search.*
import kotlinx.android.synthetic.main.inc_search_list.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class SearchFragmentTest: FragmentTestBase<SearchFragment>() {

    @Mock
    lateinit var mockAdapter: SearchListAdapter

    @Before
    fun setup(){
        createFragment()
    }

    /*
     * Test
     */

    @Test
    fun whenOnCreate_thenRecyclerViewSetup_andThenDisplayEmptyBadge(){
        thenRecyclerViewSetup()
        thenDisplayEmptyScreen()
    }


    /*
     * Then
     */
    private fun thenRecyclerViewSetup() {
        with(fragment.searchJobListingRecyclerView){
            assertEquals(adapter, mockAdapter)
            assertTrue(layoutManager is LinearLayoutManager)
            assertTrue(hasFixedSize())
        }
    }

    private fun thenDisplayEmptyScreen() {
        assertTrue(fragment.emptySearchLayout.isVisible)
        assertFalse(fragment.searchJobListingRecyclerView.isVisible)
    }

}