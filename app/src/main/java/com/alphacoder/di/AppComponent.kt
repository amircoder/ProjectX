package com.alphacoder.di

import android.app.Application
import com.alphacoder.core.di.*
import com.alphacoder.search.di.SearchActivityBinding
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidModule::class,
        NetworkModule::class,
        DataModule::class,
        UseCaseModule::class,
        ServiceModule::class,
        PersistenceModule::class,
        ViewModelFactoryModule::class,
        RxModule::class,
        SearchActivityBinding::class
    ]
)
interface AppComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)

}
