package com.alphacoder.core.extension

import android.app.Activity
import android.app.Fragment
import android.view.Window
import android.view.WindowManager
import com.alphacoder.core.base.BaseActivity


fun Activity.makeFullScreen(){
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
}

fun Activity.navigate(layout: Int, fragment: Fragment, tag: String) =
    fragmentManager.beginTransaction().add(layout, fragment, tag).commit()

