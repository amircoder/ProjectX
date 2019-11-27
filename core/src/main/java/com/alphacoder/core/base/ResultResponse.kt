package com.alphacoder.core.base

sealed class ResultResponse<T, U:Throwable> {

    data class Success<T, U:Throwable?>(val data: T  , val error: U ): ResultResponse<T, Throwable>()
    data class Failure< T, U:Throwable?>(val data: T, val throwable: U): ResultResponse<T, Throwable>()
    class Loading<T,U:Throwable>: ResultResponse<T, U>()

    override fun toString(): String {
        return when (this){
            is Success<*, *> -> "success: [data = $data]"
            is Failure<*, *> -> "error [exception: $throwable]"
            is Loading -> "Loading"
        }
    }


}