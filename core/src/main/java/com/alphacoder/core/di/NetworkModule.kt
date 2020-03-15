package com.alphacoder.core.di

import android.content.Context
import androidx.annotation.NonNull
import com.alphacoder.core.BuildConfig
import com.alphacoder.core.util.ImageLoader
import com.alphacoder.core.util.ImageLoaderImpl
import com.alphacoder.core.util.NetworkInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {


    @Provides
    @Singleton
    fun provideHttpClient(context: Context): OkHttpClient {

        return OkHttpClient.Builder()
//            .addInterceptor(RequestInterceptor())
            .addInterceptor(NetworkInterceptor())
            .addInterceptor(ChuckInterceptor(context))
            .readTimeout(10, TimeUnit.SECONDS)
//            .followRedirects(true)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideImageLoader():ImageLoader = ImageLoaderImpl()

}
