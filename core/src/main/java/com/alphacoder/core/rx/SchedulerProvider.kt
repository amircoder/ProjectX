package com.alphacoder.core.rx

import io.reactivex.Scheduler

interface SchedulerProvider {

    val ioScheduler: Scheduler
    val mainScheduler: Scheduler


}