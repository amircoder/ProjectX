package com.alphacoder.core.util.delegate

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alphacoder.core.extension.put
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * A delegate class that aims to make a cleaner argument passing for fragments
 * for more info take a look into: [https://proandroiddev.com/kotlin-delegates-in-android-1ab0a715762d]
 */
class FragmentArgumentDelegate<T : Any> :
    ReadWriteProperty<Fragment, T> {

    @Suppress("UNCHECKED_CAST")
    override fun getValue(
        thisRef: Fragment,
        property: KProperty<*>
    ): T {
        val key = property.name
        return thisRef.arguments
            ?.get(key) as? T
            ?: throw IllegalStateException("Property ${property.name} could not be read")
    }

    override fun setValue(
        thisRef: Fragment,
        property: KProperty<*>, value: T
    ) {
        val args = thisRef.arguments ?: Bundle().also(thisRef::setArguments)
        val key = property.name
        args.put(key, value)
    }
}

/*
  usage :
  class DemoFragment : Fragment() {
    private var param1: Int by FragmentArgumentDelegate()
    private var param2: String by FragmentArgumentDelegate()
    companion object {
        fun newInstance(param1: Int, param2: String): DemoFragment =
            DemoFragment().apply {
                this.param1 = param1
                this.param2 = param2
            }
    }
}
 */