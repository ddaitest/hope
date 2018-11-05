package com.daivp.hope

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.TimeUnit


object APIManager {

    private val okHttpClient = OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor()).build()

    /**
     * app_device	应用设备号
    app_version	应用版本号
    name	姓名
    mobile	手机号
    gender	性别 1 男 2女
    time_start	时间戳， 时间段开始时间
    time_end	时间戳， 时间段结束时间
    addr_start	起点
    addr_end	终点
    num_seat	座位数
    remark	备注
     */
    fun publish(name: String, mobile: String, gender: Int, time_start: String, time_end: String, addr_start: String, addr_end: String, num_seat: String, remark: String,
                success: (JSONObject) -> Unit,fail: (Boolean) -> Unit) {
        val requestBody = FormBody.Builder()
                .add("app_device", "1")
                .add("app_version", "1")
                .add("mobile", mobile)
                .add("gender", gender.toString())
                .add("time_start", time_start)
                .add("time_end", time_end)
                .add("addr_start", addr_start)
                .add("addr_end", addr_end)
                .add("num_seat", num_seat.toString())
                .add("remark", remark)
                .add("name", name)
                .build()
        val request = Request.Builder().url("http://daivp.com/api/car2_person/publish").post(requestBody).build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                fail(false)
            }

            override fun onResponse(call: Call?, response: Response?) {
                val json = response?.body()?.string()?.let {
                    JSONObject(it)
                }
                if (json != null) {
                    success(json)
                } else {
                    fail(false)
                }
            }
        })
    }

    fun list(page: Int, page_size: Int, success: (JSONObject) -> Unit,fail: (Boolean) -> Unit) {
        val requestBody = FormBody.Builder()
                .add("page", page.toString())
                .add("page_size", page_size.toString())
                .add("chief _num", "1")
                .build()
        val request = Request.Builder().url("http://daivp.com/api/car2_person/getlist").post(requestBody).build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                fail(false)
            }

            override fun onResponse(call: Call?, response: Response?) {
                val json = response?.body()?.string()?.let {
                    JSONObject(it)
                }
                if (json != null) {
//                    fail(json.optInt("result", 0) == 1)
                    success(json)
                } else {
                    fail(false)
                }
            }
        })
    }
}

/**
 * name	姓名
mobile	手机号
time_start	时间戳， 时间段开始时间
time_end	时间戳， 时间段结束时间
addr_start	起点
addr_end	终点
remark	备注
 */
class Task2(
        val name: String,
        val mobile: String,
        val time_start: Long,
        val time_end: Long,
        val addr_start: String,
        val addr_end: String,
        val remark: String
)