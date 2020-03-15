package com.alphacoder.core.domain

import com.alphacoder.core.base.ResultResponse

interface UseCase<T: ResultResponse<R, U>, R,U:Throwable> {
    fun cancel()
}
