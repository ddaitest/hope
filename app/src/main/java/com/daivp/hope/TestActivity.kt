package com.daivp.hope

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
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

//        val animator = AnimatorInflater.loadAnimator(this, R.animator.wsapp)
        val animator = AnimUtil.getAA(image_header)
//        animator.setTarget(image_header)
        animator.start()
        image_header.setOnClickListener {
            animator.start()
        }
        button8.setOnClickListener {
            animator.end()
        }
        button9.setOnClickListener {
            animator.cancel()
        }
    }

}


