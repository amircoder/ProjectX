package com.alphacoder.core.extension

import android.app.Activity
import android.view.Window
import android.view.WindowManager

fun Activity.makeFullScreen(){
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
}