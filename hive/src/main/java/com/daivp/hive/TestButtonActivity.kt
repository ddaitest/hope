package com.daivp.hive

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.activity_test_button.*
import kotlinx.android.synthetic.main.test_in.*

class TestButtonActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        window.statusBarColor = Color.TRANSPARENT
        Fresco.initialize(this)
        title = "selectableItemBackground"
        setContentView(R.layout.activity_test_button)
        cl_1.setOnClickListener { }
        cl_2.setOnClickListener { }
        cl_3.setOnClickListener { }
        test1.setOnClickListener { }
        test2.setOnClickListener { }

        tv1.setOnClickListener { }
        tv2.setOnClickListener { }
        iv1.setOnClickListener { }
        iv3.setOnClickListener { }
        iv3.setImageURI("https://upload-images.jianshu.io/upload_images/8379708-15897095867967df.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/700")

        go.setOnClickListener { startActivity(Intent(this@TestButtonActivity, ButtonsActivity::class.java)) }
        in_tv1.text = "AAA"
        in_tv2.text = "BBB"
        in_tv3.text = "CCC"
    }
}
