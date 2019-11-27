package com.alphacoder.core.util.test

import androidx.lifecycle.Observer

class TestableViewObserver<T: Any> : Observer<T>{

    val observedList = mutableListOf<T>()

    override fun onChanged(t: T) {
        observedList.add(t)
    }

}