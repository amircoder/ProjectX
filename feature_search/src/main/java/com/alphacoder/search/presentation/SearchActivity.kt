package com.alphacoder.search.presentation

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alphacoder.core.view.ErrorSuccessActivity
import com.alphacoder.feature_search.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class SearchActivity : ErrorSuccessActivity(), HasSupportFragmentInjector {

    override val contentResourceId: Int
        get() = R.layout.activity_main


    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        initNavigationController()

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    private fun initNavigationController() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        supportActionBar?.hide()

    }

}