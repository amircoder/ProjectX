package com.alphacoder.core.view

import android.os.Bundle
import com.alphacoder.core.R
import com.alphacoder.core.base.BaseActivity
import com.alphacoder.core.extension.hide
import com.alphacoder.core.extension.show
import com.alphacoder.core.callback.view.ErrorSuccessCallback
import com.alphacoder.core.extension.makeFullScreen
import kotlinx.android.synthetic.main.activity_error_success_content.*

abstract class ErrorSuccessActivity : BaseActivity(), ErrorSuccessCallback {

    internal companion object {
        internal const val VIEW_INDEX_CONTENT = 0
        internal const val VIEW_INDEX_ERROR = 1
    }

    protected abstract val contentResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        this.makeFullScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error_success_content)
        errorContentContainer.addView(layoutInflater.inflate(contentResourceId, null))
    }

    open fun onErrorAction() {

    }

    open fun onEmptyAction() {

    }

    override fun showLoadingSpinner() {
        switchToView(VIEW_INDEX_CONTENT)
        errorLoadingView.show()
    }

    override fun hideLoadingSpinner() {
        errorLoadingView.hide()
    }

    override fun displayGenericErrorMessage() {
        showErrorScreen(
            getString(R.string.generic_fail_title),
            getString(R.string.generic_network_error),
            getString(R.string.generic_error_button_text)
        )
    }

    override fun displayNetworkErrorMessage() {
        showErrorScreen(
            getString(R.string.generic_fail_title),
            getString(R.string.generic_network_error),
            getString(R.string.generic_error_button_text)
        )
    }

    override fun displayCustomError(title: String, msg: String) {
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


