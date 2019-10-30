package com.alphacoder.core.base

import com.alphacoder.core.extension.plusAssign
import com.twistedequations.rx2.AndroidRxSchedulers
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.plugins.RxJavaPlugins


abstract class BaseUseCase<T : ResultResponse<R, U>, R, U : Throwable> constructor(
    val androidSchedulers: AndroidRxSchedulers
) : UseCase<T, R, U> {

    private val onSuccessStub: (T) -> Unit = {}
    private val onFailureStub: (Throwable) -> Unit = {error ->
        RxJavaPlugins.onError(
            OnErrorNotImplementedException(error)
        )
    }

    private val compositeDisposable = CompositeDisposable()

    override fun cancel() = compositeDisposable.dispose()

    protected fun Observable<T>.executeUseCase(
        onSuccess: (T) -> Unit = onSuccessStub,
        onFailure: (Throwable) -> Unit = onFailureStub

    ) {
        compositeDisposable.clear()

        compositeDisposable += this
            .subscribeOn(androidSchedulers.io())
            .observeOn(androidSchedulers.mainThread())
            .subscribe(onSuccess, onFailure)
    }


}