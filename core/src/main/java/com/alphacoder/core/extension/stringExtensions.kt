package com.alphacoder.core.extension

import android.content.Context
import android.widget.Toast

fun String.displayLongToast(context: Context){
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}

fun String.displayShortToast(context: Context){
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}