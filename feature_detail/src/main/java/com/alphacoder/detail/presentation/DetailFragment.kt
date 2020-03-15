package com.alphacoder.detail.presentation

import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModelProvider
import com.alphacoder.core.AppConfig
import com.alphacoder.core.util.ImageLoader
import com.alphacoder.core.view.ErrorSuccessFragment
import com.alphacoder.feature_detail.R
import javax.inject.Inject

class DetailFragment: ErrorSuccessFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var appConfig: AppConfig
    @Inject
    lateinit var imageLoader: ImageLoader

    lateinit var viewModel: DetailViewModel


    companion object {
        private const val JOB_ID = "JOB_ID"
        fun newInstance(jobId: String) = DetailFragment().apply {
            arguments = Bundle().apply {
                putString(JOB_ID, jobId)
            }
        }
    }

    override val contentResourceId: Int
        get() = R.layout.fragment_detail


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

    }

    override fun initViewListeners() {

    }

    override fun initObservers() {

    }
}