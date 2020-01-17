package com.alphacoder.detail.ui

import android.os.Bundle
import com.alphacoder.core.view.ErrorSuccessActivity
import com.alphacoder.feature_detail.R

class DetailActivity: ErrorSuccessActivity() {

    override val contentResourceId: Int
        get() = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onErrorAction() {
        super.onErrorAction()
    }

    override fun onEmptyAction() {
        super.onEmptyAction()
    }

}