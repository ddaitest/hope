package com.daivp.hope

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private var client = OkHttpClient()
    val domain = "http://daivp.com"
//    val domain = "http://192.168.199.239:8000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
//            val body = FormBody.Builder()
//            body.add("start_at", "xx")
//            body.add("end_at", "yy")
//            body.add("departure", (System.currentTimeMillis()/1000).toString())
//            body.add("quota", "1")
//            body.add("remark", "abc")
//            Request.Builder()
//                    .url("$domain/hope/add_task_api/")
//                    .post(body.build())
//                    .build().go()
            Snackbar.make(cl_3, "message_text", Snackbar.LENGTH_SHORT)
                    .setAction("action_text"){
                        Log.d("DDAI","click!!!")
                    }
                    .show()
        }
        button2.setOnClickListener {
            Request.Builder()
                    .url("$domain/hope/tasks/")
                    .get().build().go()
        }
        button3.setOnClickListener {
            val jo = JSONObject().apply {
                put("start_at", "啊")
                put("end_at", "yy")
                put("departure", System.currentTimeMillis()/1000)
                put("quota", "1")
                put("remark", "abc")
            }
            val body = FormBody.Builder()
            body.add("json", jo.toString())
            Request.Builder()
                    .url("$domain/hope/add_task_api/")
                    .post(body.build())
                    .build().go()
        }
    }


    private fun Request.go() {
        client.newCall(this).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                Log.d("DDAI", "onFailure=${e?.message}")
            }

            override fun onResponse(call: Call?, response: Response?) {
                Log.d("DDAI", "onResponse=${response?.body()?.string()}")
            }

        })
    }
}


