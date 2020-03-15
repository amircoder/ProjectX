package com.alphacoder.navigation

import com.alphacoder.core.base.BaseFragment
import com.alphacoder.core.util.FragmentNavigationHelper
import com.alphacoder.detail.presentation.DetailFragment

class GermanFragmentNavigationHelper:
    FragmentNavigationHelper {
    override fun getDetailFragment(jobId: String): BaseFragment = DetailFragment.newInstance(jobId)
    override fun getDetailFragmentTag() = "DetailFragment"
}