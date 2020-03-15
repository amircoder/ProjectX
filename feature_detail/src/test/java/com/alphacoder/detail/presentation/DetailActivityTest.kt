package com.alphacoder.detail.presentation

import android.view.View
import android.widget.LinearLayout
import com.alphacoder.core.ActivityTestBase
import com.alphacoder.extesnsion.isVisible
import com.alphacoder.feature_detail.R
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DetailActivityTest: ActivityTestBase<DetailActivity>() {

    private val layoutContainer by lazy {
        activity.findViewById<LinearLayout>(R.id.detailLayoutContainer)
    }



    @Before
    fun setup(){
        createActivity()
    }


    @Test
    fun `whenStart thenLayoutContainerIsVisible`(){
        thenLayoutContainerIsVisible()
    }

    /*
     THEN
     */
    private fun thenLayoutContainerIsVisible() {
        assertEquals(layoutContainer isVisible View.VISIBLE , true )
    }
}