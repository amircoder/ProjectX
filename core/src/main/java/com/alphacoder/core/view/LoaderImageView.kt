package com.alphacoder.core.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.alphacoder.core.R

class LoaderImageView(context: Context, attributeSet: AttributeSet)
    : AppCompatImageView(context, attributeSet) {

    private val animatedVector  by lazy {
        AnimatedVectorDrawableCompat.create(
            context,
            R.drawable.animator_vector
        )!!
    }

    init {
        setImageDrawable(animatedVector)
        val visibility = visibility
        startOrStopAnimation(visibility)

    }

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        startOrStopAnimation(visibility)
    }

    private fun startOrStopAnimation(visibility: Int) {
        if (visibility == View.VISIBLE){
            animatedVector.start()
        }else {
            animatedVector.stop()
        }
    }

}