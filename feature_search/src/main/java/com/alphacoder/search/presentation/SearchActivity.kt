package com.alphacoder.search.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alphacoder.core.extension.makeFullScreen
import com.alphacoder.core.view.ErrorSuccessActivity
import com.alphacoder.feature_search.BuildConfig
import com.alphacoder.feature_search.R
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector


class SearchActivity : ErrorSuccessActivity(), HasSupportFragmentInjector {

    override val contentResourceId: Int
        get() = R.layout.activity_main


    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        initNavigationController()

    }


    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    private fun initNavigationController() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        supportActionBar?.hide()

    }

}