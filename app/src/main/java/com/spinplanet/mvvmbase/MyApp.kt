package com.spinplanet.mvvmbase

import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.spinplanet.mvvmbase.di.AppComponent
import com.spinplanet.mvvmbase.di.ApplicationModule
import com.spinplanet.mvvmbase.di.DaggerAppComponent
import dagger.android.DaggerApplication
import java.lang.ref.WeakReference

class MyApp : Application(), LifecycleObserver {

    companion object {
        private var foreground = false
        private lateinit var myApplicationContext: WeakReference<Context>
        lateinit var component: AppComponent
            private set

        fun isForeground(): Boolean {
            return foreground
        }

        fun getMyApplicationContext(): WeakReference<Context> {
            return myApplicationContext
        }
    }


    override fun onCreate() {
        super.onCreate()

        myApplicationContext = WeakReference(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)

        setupComponent()
    }

    private fun setupComponent() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)

    }

}