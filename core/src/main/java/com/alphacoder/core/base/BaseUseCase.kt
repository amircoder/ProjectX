package com.alphacoder.core.base

import com.alphacoder.core.domain.UseCase
import com.alphacoder.core.extension.plusAssign
import com.alphacoder.core.rx.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.plugins.RxJavaPlugins


abstract class BaseUseCase<T : ResultResponse<R, U>, R, U : Throwable> constructor(
    private val androidSchedulers: SchedulerProvider
) : UseCase<T, R, U> {

    private val onSuccessStub: (T) -> Unit = {}
    private val onFailureStub: (Throwable) -> Unit = { error ->
        RxJavaPlugins.onError(
            OnErrorNotImplementedException(error)
        )
    }

    private val compositeDisposable = CompositeDisposable()

    override fun cancel() = compositeDisposable.dispose()

    open fun Observable<T>.executeUseCaseObserveOnMainSubscribeOnIO(
        onSuccess: (T) -> Unit = onSuccessStub,
        onFailure: (Throwable) -> Unit = onFailureStub
    ) {
        compositeDisposable.clear()


        // += means plus assign and simply acts like add method for CompositeDisposable
        compositeDisposable += this
            .subscribeOn(androidSchedulers.ioScheduler)
            .observeOn(androidSchedulers.mainScheduler)
            // Note:   cast to T (as T) is a work-around to make the rx chain sound and sane,
            //         as startwith won't work without this cast, due to it's definition.
            //         to find out more take a look into it's method definitions/signatures.
            .startWith(ResultResponse.Loading<R, U>() as T)
            .subscribe({ onSuccess(it) }, onFailure)
    }


}
