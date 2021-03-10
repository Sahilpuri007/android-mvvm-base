package com.spinplanet.mvvmbase.utils.extensions

import android.app.Activity
import android.content.Intent
import android.os.Bundle

fun Activity.goToActivity(newActivity: Class<*>, extras: Bundle?, doFinish: Boolean) {
    val intent = Intent(this, newActivity)
    if (extras != null) intent.putExtras(extras)
    startActivity(intent)
    if (doFinish) this.finish()
}

fun Activity.goToActivityWithResult(
    newActivity: Class<*>,
    doFinish: Boolean,
    extras: Bundle?,
    requestCode: Int
) {
    val intent = Intent(this, newActivity)
    if (extras != null) intent.putExtras(extras)
    this.startActivityForResult(intent, requestCode)
    if (doFinish) this.finish()
}