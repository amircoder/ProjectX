package com.alphacoder.core.util

import com.alphacoder.core.base.BaseFragment

interface FragmentNavigationHelper {
    fun getDetailFragment(jobId: String) : BaseFragment
    fun getDetailFragmentTag() : String

}