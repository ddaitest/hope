package com.daivp.hope

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_abc.*

class ABCActivity : AppCompatActivity() {

    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_abc)
        header_tag.text = "osososososos"
        header_name.text = "XXYYCC"
        image_header.setOnClickListener {


            addOne()
        }
    }

    private fun addOne() {



        header_tag.text = "osoososososoos+${++i}"


        }
    }


