package com.alphacoder.core.base

sealed class ResultResponse<out T> {

    data class Success<out T>(val data: T): ResultResponse<T>()
    data class Failure(val throwable: Throwable): ResultResponse<Throwable>()
    class Loading<T>: ResultResponse<T>()

    override fun toString(): String {
        return when (this){
            is Success -> "success: [data = $data]"
            is Failure -> "error [exception: $throwable]"
            is Loading -> "Loading"
        }
    }


}