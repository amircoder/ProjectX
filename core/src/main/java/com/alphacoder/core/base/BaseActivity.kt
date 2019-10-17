package com.alphacoder.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {


//    @Inject
//    lateinit var themeProvider: ThemeProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applyThem()
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

    private fun applyThem() {
        // TODO: get theme from theme provider
//        setTheme(themeProvider.getTheme())
    }

}