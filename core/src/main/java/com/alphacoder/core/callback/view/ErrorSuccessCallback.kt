package com.alphacoder.view

interface ErrorSuccessCallback {
    fun showLoadingSpinner()
    fun hideLoadingSpinner()
    fun displayServerErrorMessage()
    fun displayNetworkErrorMessage()
}
