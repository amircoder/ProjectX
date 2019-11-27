package com.alphacoder.core.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers


class TrampolineSchedulerProvider: SchedulerProvider {

    override val ioScheduler: Scheduler = Schedulers.trampoline()
    override val mainScheduler: Scheduler = Schedulers.trampoline()

}