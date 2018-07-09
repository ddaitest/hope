package com.daivp.hive

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        test_button.setOnClickListener { startActivity(Intent(this@TestActivity, TestButtonActivity::class.java)) }
        test_anim.setOnClickListener { startActivity(Intent(this@TestActivity, TestButtonActivity::class.java)) }
    }
}
