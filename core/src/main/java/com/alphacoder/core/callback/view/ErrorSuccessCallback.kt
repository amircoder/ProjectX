package com.alphacoder.core.callback.view

interface ErrorSuccessCallback {
    fun showLoadingSpinner()
    fun hideLoadingSpinner()
    fun displayGenericErrorMessage()
    fun displayNetworkErrorMessage()
    fun displayCustomError(title: String, msg: String)
}
