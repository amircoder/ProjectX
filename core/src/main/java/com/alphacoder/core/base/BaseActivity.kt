package com.alphacoder.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alphacoder.view.ThemeProvider
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {


    @Inject
    lateinit var themeProvider: ThemeProvider
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        applyTheme()
    }



    override fun onResume() {
        super.onResume()
        // TODO: Some global operation here
    }

    override fun onPause() {
        super.onPause()
        // TODO: Some global operation here
    }

    override fun onStop() {
        super.onStop()
        // TODO: Some global operation here
    }

    private fun applyTheme() {
        setTheme(themeProvider.theme)
    }


}