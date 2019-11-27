package com.alphacoder.core.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.alphacoder.core.R

/**
 * A test Custom [View] for learning purposes.
 * To take a sneak peek of [View] life cycle take a look into:
 * [https://miro.medium.com/max/1384/1*abc0UlGj1myFD0eph4pZjQ.png]
 */
class StrokeCircularTextView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyle: Int
) : TextView(context, attributeSet, defStyle) {

    companion object {
        const val INITIAL_WIDTH = 2F
    }

    private lateinit var circlePaint: Paint

    private val strokePaint by lazy {
        Paint().apply {
            color = Color.YELLOW
            flags = Paint.ANTI_ALIAS_FLAG
        }
    }

    private var h: Float = 0F
    private var w: Float = 0F
    private var diameter = 0F
    private var radius: Float = 0F
    private var strokeWidth: Float = INITIAL_WIDTH
    internal var solidColor: Int = 0
        set(value) {
            field = value
            circlePaint.color = value
        }
    internal var strokeColor: Int = 0
        set(value) {
            field = value
            strokePaint.color = value
        }

    init {
        val typedArray = context.obtainStyledAttributes(attributeSet,
            R.styleable.CircularTextView)
        circlePaint.color = typedArray.getColor(
            R.styleable.CircularTextView_CircularFillColor, Color.BLUE)
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        h = heightMeasureSpec.toFloat()
        w = widthMeasureSpec.toFloat()
        diameter = if (h > w) h else w
        radius = diameter / 2

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    override fun onDraw(canvas: Canvas?) {

        canvas?.drawCircle(diameter / 2, diameter / 2, radius, strokePaint)
        canvas?.drawCircle(diameter / 2, diameter / 2, radius - strokeWidth, circlePaint)

        super.onDraw(canvas)
    }

    fun setSodlidColor(color: String) {
        circlePaint.color = Color.parseColor(color)
        postInvalidate()
    }

    fun setStrokePaint(color: String) {
        strokePaint.color = Color.parseColor(color)
        postInvalidate()
    }

    fun setStrokeWidth(width: Int) {
        strokeWidth = width.toFloat()
        postInvalidate()
    }

}