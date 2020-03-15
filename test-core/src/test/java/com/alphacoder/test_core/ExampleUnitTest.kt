package com.alphacoder.test_core

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        val someConstant: Int = 1
        var someVariable: Int = 2

        var someString: String = "some string"
        var someDouble: Double = 1.0

        someVariable = 3

        println(" variable: $someVariable and constant: $someConstant ")

    }
}
