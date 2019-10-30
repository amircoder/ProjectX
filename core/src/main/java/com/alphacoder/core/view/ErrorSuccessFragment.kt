package com.alphacoder.core.view

import android.os.Bundle
import android.view.View
import com.alphacoder.core.base.BaseFragment
import com.alphacoder.view.ErrorSuccessCallback

abstract class ErrorSuccessFragment : BaseFragment(), ErrorSuccessCallback {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewListeners()
        initObservers()
    }

    abstract fun initViewListeners()
    abstract fun initObservers()

    override fun showLoadingSpinner() {
        (activity as ErrorSuccessActivity).showLoadingSpinner()
    }

    override fun hideLoadingSpinner() {
        (activity as ErrorSuccessActivity).hideLoadingSpinner()
    }

    override fun displayServerErrorMessage() {
        (activity as ErrorSuccessActivity).displayServerErrorMessage()
    }

    override fun displayNetworkErrorMessage() {
        (activity as ErrorSuccessActivity).displayNetworkErrorMessage()
    }



}