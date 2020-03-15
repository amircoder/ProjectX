package com.alphacoder.core.base

import com.alphacoder.core.util.FragmentNavigationHelper
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var fragmentNavigator: FragmentNavigationHelper

    override fun onStart() {
        super.onStart()
        // TODO: Some global operation here
    }

    override fun onResume() {
        super.onResume()
        // TODO: Some global operation here
    }

    override fun onPause() {
        super.onPause()
        // TODO: Some global operation here
    }

//    fun navigate(layout: Int, fragment: BaseFragment, tag: String){
//        parentFragmentManager.beginTransaction().add(layout, fragment, tag).addToBackStack(null)
//            .commit()
//    }


}