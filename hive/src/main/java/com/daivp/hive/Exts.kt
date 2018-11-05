package com.daivp.hive

import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat

/**
 * Created by daining on 2018/4/14.
 */
inline fun Activity.runPermission(p: String, t: () -> Unit) {
    if (ActivityCompat.checkSelfPermission(this, p) == PackageManager.PERMISSION_GRANTED) {
        t.invoke()
    }

}

//@Retention(RetentionPolicy.RUNTIME)
@Retention()
@kotlin.annotation.Target(AnnotationTarget.CLASS)
annotation class PageName(val value: String = "")