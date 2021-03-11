package com.spinplanet.mvvmbase.di

import com.spinplanet.mvvmbase.BuildConfig
import com.spinplanet.mvvmbase.data.network.ApiInterface
import com.spinplanet.mvvmbase.data.DataRepositoryImpl
import com.spinplanet.mvvmbase.data.local.dao.DataDao
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun getOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun getApiInterface(retroFit: Retrofit): ApiInterface {
        return retroFit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun getDataRepository(apiInterface: ApiInterface, myDataDao: DataDao): DataRepositoryImpl {
        return DataRepositoryImpl(apiInterface, myDataDao)
    }

}