package com.alphacoder.core.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alphacoder.core.R
import com.alphacoder.core.base.BaseFragment
import com.alphacoder.core.callback.view.ErrorSuccessCallback
import com.alphacoder.core.extension.hide
import com.alphacoder.core.extension.show
import kotlinx.android.synthetic.main.activity_error_success_content.*
import kotlinx.android.synthetic.main.fragment_error_success.view.*

abstract class ErrorSuccessFragment: BaseFragment(), ErrorSuccessCallback {

    protected abstract val contentResourceId: Int

    internal companion object {
        internal const val VIEW_INDEX_CONTENT = 0
        internal const val VIEW_INDEX_ERROR = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_error_success, container, false)
        view.errorContentContainer.addView(layoutInflater.inflate(contentResourceId, null))
        return view


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewListeners()
        initObservers()
        setupRecyclerView()
        setupView()
    }

    abstract fun initViewListeners()
    abstract fun initObservers()

    open fun setupRecyclerView(){

    }

    open fun setupView(){

    }

    open fun onErrorAction() {

    }

    open fun onEmptyAction() {

    }

    override fun showLoadingSpinner() {
//        (activity as ErrorSuccessActivity).showLoadingSpinner()
        switchToView(VIEW_INDEX_CONTENT)
        errorLoadingView.show()
    }

    override fun hideLoadingSpinner() {
        errorLoadingView.hide()
//        (activity as ErrorSuccessActivity).hideLoadingSpinner()
    }

    override fun displayGenericErrorMessage() {
//        (activity as ErrorSuccessActivity).displayGenericErrorMessage()
        showErrorScreen(
            getString(R.string.generic_fail_title),
            getString(R.string.generic_network_error),
            getString(R.string.generic_error_button_text)
        )
    }

    override fun displayNetworkErrorMessage() {
//        (activity as ErrorSuccessActivity).displayNetworkErrorMessage()
        showErrorScreen(
            getString(R.string.generic_fail_title),
            getString(R.string.generic_network_error),
            getString(R.string.generic_error_button_text)
        )
    }

    override fun displayCustomError(title: String, msg: String){
//        (activity as ErrorSuccessActivity).displayCustomError(title, msg)
        showErrorScreen(
            title,
            msg,
            getString(R.string.generic_error_button_text)
        )
    }

    private fun showErrorScreen(string: String, string1: String, string2: String) {
        switchToView(VIEW_INDEX_ERROR)
    }

    private fun switchToView(viewIndexContent: Int) {
        with(errorSuccessViewSwitcher) {
            if (viewIndexContent != displayedChild) {
                displayedChild = viewIndexContent
            }
        }
    }





}