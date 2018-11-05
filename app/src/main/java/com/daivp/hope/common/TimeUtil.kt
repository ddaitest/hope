package com.daivp.hope.common

import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {
    val serverFormat = "yyyy-MM-dd HH:mm:ss"
    val viewFormat = "MM月dd日 HH:mm:ss"
    val view = SimpleDateFormat(viewFormat, Locale.CHINA)
    val server = SimpleDateFormat(serverFormat, Locale.CHINA)

    fun s2v(time: String): String {
        return view.format(server.parse(time))
    }

    fun v2s(time: String): String {
        return server.format(view.parse(time))
    }

}