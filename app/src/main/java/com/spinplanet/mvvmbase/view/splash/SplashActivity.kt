package com.spinplanet.mvvmbase.view.splash


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spinplanet.mvvmbase.R
import com.spinplanet.mvvmbase.utils.getCurrentTime
import kotlinx.android.synthetic.main.activity_splash2.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        textView.apply {
            text = getCurrentTime()
        }
    }
}