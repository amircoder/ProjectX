package com.alphacoder.core.extension

import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.visible(visible: Boolean) {
    if (visible) show() else hide()
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}


fun RecyclerView.setOnScrollDirectionListener(onScrollUp: () -> Unit, onScrollDown: () -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            when {
                dy > 30 -> onScrollUp()
                dy < -30 -> onScrollDown()
                else -> { // do nothing
                }
            }
        }
    })

}