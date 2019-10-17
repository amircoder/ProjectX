package com.alphacoder.core.base

import com.alphacoder.core.extension.plusAssign
import com.twistedequations.rx2.AndroidRxSchedulers
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.plugins.RxJavaPlugins


abstract class BaseUseCase<T> constructor(
    private val androidSchedulers: AndroidRxSchedulers
) : UseCase<T> {

    protected val onSuccessStub: (T) -> Unit = {}
    protected val onFailureStub: (Throwable) -> Unit = {
        RxJavaPlugins.onError(OnErrorNotImplementedException(it))
    }

    protected val compositeDisposable = CompositeDisposable()

    override fun cancel() = compositeDisposable.dispose()

    protected fun Observable<T>.executeUseCase(
        onSuccess: (T) -> Unit = onSuccessStub,
        onFailure: (Throwable) -> Unit = onFailureStub
    ) {

        compositeDisposable += this
            .subscribeOn(androidSchedulers.io())
            .observeOn(androidSchedulers.mainThread())
            .subscribe(onSuccess, onFailure)

    }


}