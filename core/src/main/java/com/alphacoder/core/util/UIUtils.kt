package com.alphacoder.core.util

import android.app.Activity
import android.content.Context
import android.text.Html.fromHtml
import android.text.method.LinkMovementMethod
import android.text.method.TransformationMethod
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.StringRes

object UIUtils {


    fun openKeyboard(editText: EditText) {
        val inputMethodManager =
            editText.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    }

    fun closeKeyboard(editText: EditText) {
        val inputMethodManager =
            editText.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)
    }

    fun closeKeyboard(activity: Activity) {
        if (activity.currentFocus != null) {
            val inputMethodManager =
                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
        }
    }

    /**
     * Removes the focus from the current view and sets it to the root view by
     * recursively traversing the views tree. For this to work, the root view
     * must have the "focusable" and "focusableInTouchMode" attributes set
     * to "true".
     *
     * @param activity target activity with the focused element
     */
    fun clearFocusToRoot(activity: Activity) {
        var currentFocus: View?

        do {
            currentFocus = activity.currentFocus

            currentFocus?.clearFocus()
        } while (currentFocus != null && activity.currentFocus !== currentFocus)
    }

    fun setupTextViewWithLinks(
        textView: TextView,
        transformationMethod: TransformationMethod,
        @StringRes stringResId: Int, vararg stringFormatArgs: Any
    ) {
        setupTextViewWithLinks(
            textView,
            transformationMethod,
            textView.context.getString(stringResId, *stringFormatArgs)
        )
    }

    fun setupTextViewWithLinks(
        textView: TextView,
        transformationMethod: TransformationMethod,
        htmlText: String
    ) {
        textView.text = fromHtml(htmlText)
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.transformationMethod = transformationMethod
    }


}