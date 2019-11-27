package com.alphacoder.core.base

import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

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

}