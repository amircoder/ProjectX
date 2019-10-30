package com.alphacoder.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.alphacoder.core.util.Activities
import com.alphacoder.core.util.intentTo


class SplashActivity : AppCompatActivity() {

    private val handler by lazy {
        InnerHandler()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)

        supportActionBar?.apply { hide() }

        startListing()

    }

    private fun startListing() {
        handler.postDelayed({
            startActivity(intentTo(this, Activities.Search.SearchActivity))
            finish()
        }, 1500)

    }


    /*
     * Helper
     */

    /**
     *    create an inner class to prevent memory leak.
     *    in java code we may use static classes for this purpose.
     */
    class InnerHandler : Handler()
}
