package com.alphacoder.core.base

interface UseCase<T:ResultResponse<R,U>, R,U:Throwable> {

    fun cancel()

}
