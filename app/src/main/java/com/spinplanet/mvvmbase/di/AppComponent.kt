package com.spinplanet.mvvmbase.di


import com.spinplanet.mvvmbase.MyApp
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(app: MyApp)
}