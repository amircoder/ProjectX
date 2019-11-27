package com.alphacoder.core.util.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * A delegate class for always trimmed strings
 * for more info take a look into: [https://proandroiddev.com/kotlin-delegates-in-android-1ab0a715762d]
 */
class TrimDelegate: ReadWriteProperty<Any?, String> {

    private var trimmedValue: String = ""
    override fun getValue(thisRef: Any?, property: KProperty<*>) = trimmedValue


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        trimmedValue = value.trim()
    }

}