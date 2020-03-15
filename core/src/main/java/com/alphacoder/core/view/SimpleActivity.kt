package com.alphacoder.core.view

import android.os.Bundle
import com.alphacoder.core.base.BaseActivity
import com.alphacoder.core.extension.makeFullScreen

abstract class SimpleActivity: BaseActivity() {

    protected abstract val contentResourceId: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        this.makeFullScreen()
        super.onCreate(savedInstanceState)
        setContentView(layoutInflater.inflate(contentResourceId, null))
    }


}