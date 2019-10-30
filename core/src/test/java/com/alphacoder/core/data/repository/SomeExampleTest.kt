package com.alphacoder.core.data.repository

import org.junit.Test

class SomeExampleTest {

    @Test
    fun calcFuctoriel(){
        val limit = 365 *2
        var sum = 16
        for (numer: Int in 1..limit){
            sum += (sum * 2 )
        }

        println(sum / 10000000)
    }

}