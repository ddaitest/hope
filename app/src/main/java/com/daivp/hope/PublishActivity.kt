package com.daivp.hope

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.daivp.hope.common.TimeUtil
import kotlinx.android.synthetic.main.activity_publish.*
import java.util.*

class PublishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish)
        setupActionBar()
        bt_publish.setOnClickListener { publish() }
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private fun setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    fun publish() {
        val m = mobile.text.toString()
        val s = start.text.toString()
        val e = end.text.toString()
        val q = quota.text.toString()
        val r = remark.text.toString()

        if (m.isNullOrEmpty()) {
            mobile_input_layout.error = "mobile is empty"
            Snackbar.make(bt_publish, "mobile is empty", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (s.isNullOrEmpty()) {
            Snackbar.make(bt_publish, "start is empty", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (e.isNullOrEmpty()) {
            Snackbar.make(bt_publish, "end is empty", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (q.isNullOrEmpty()) {
            Snackbar.make(bt_publish, "quota is empty", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (r.isNullOrEmpty()) {
            Snackbar.make(bt_publish, "remark is empty", Snackbar.LENGTH_SHORT).show()
            return
        }
        val time = TimeUtil.server.format(Date(System.currentTimeMillis()))
        APIManager.publish(m, m, 1, time, time, s, e, q, r, {
            Log.w("DDAI", "success @ $it")
            setResult(1)
            finish()
        }, {
            Log.w("DDAI", "fail @ publish")
        })
    }

}
