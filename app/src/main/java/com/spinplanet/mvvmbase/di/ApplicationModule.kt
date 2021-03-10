package com.spinplanet.mvvmbase.di

import android.app.Application
import com.spinplanet.mvvmbase.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var myApp:MyApp) {

    @Provides
    @Singleton
    fun provideApp(): Application {
        return myApp
    }
}