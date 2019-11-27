package com.alphacoder.core.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView

class CircularTextView : TextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    )

    val circularPaint = Paint().apply {
        color = Color.RED
        strokeWidth = 2F
        flags = Paint.ANTI_ALIAS_FLAG

    }

    private var h: Int = 0
    private var w: Int = 0
    private var diameter: Int = 0
    private var radius: Int = 0


    override fun onDraw(canvas: Canvas?) {

        h = this.height
        w = this.width
        diameter = if (w > h) w else h
        radius = diameter / 2

        canvas?.drawCircle(
            (diameter / 2).toFloat(),
            (diameter / 2).toFloat(),
            radius.toFloat(), circularPaint
        )
        super.onDraw(canvas)
    }

}