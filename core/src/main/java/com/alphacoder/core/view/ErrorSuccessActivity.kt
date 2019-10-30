package com.alphacoder.core.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alphacoder.core.R
import com.alphacoder.core.base.BaseActivity
import com.alphacoder.core.extension.hide
import com.alphacoder.core.extension.show
import com.alphacoder.view.ErrorSuccessCallback
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_error_success_content.*
import javax.inject.Inject

abstract class ErrorSuccessActivity : BaseActivity(), ErrorSuccessCallback{

    internal companion object {
        internal const val VIEW_INDEX_CONTENT = 0
        internal const val VIEW_INDEX_ERROR = 1
    }



    protected abstract val contentResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {


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

    override fun displayServerErrorMessage() {
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


