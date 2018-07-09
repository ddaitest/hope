package com.daivp.hive

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_anim.*
import java.lang.Math.max


class AnimActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)
        textView5.setOnClickListener { }
        rl_a.setOnClickListener {
            cv_a.visibility = View.VISIBLE
            show(cv_a).start()
        }
        cv.setOnClickListener {
            cv_a.visibility = View.VISIBLE
            hide(cv_a).apply {
                addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        cv_a.visibility = View.INVISIBLE
                    }
                })
                start()
            }
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            Toast.makeText(this@AnimActivity, "Select ${it.title}", Toast.LENGTH_SHORT).show()
            true
        }

        button.setOnClickListener {
        }
    }

    fun show(view: View): Animator {
        return ViewAnimationUtils.createCircularReveal(view, (view.left + view.right) / 2, (view.top + view.bottom) / 2, 0f, max(view.width, view.height).toFloat())
    }

    fun hide(view: View): Animator {
        return ViewAnimationUtils.createCircularReveal(view, (view.left + view.right) / 2, (view.top + view.bottom) / 2, max(view.width, view.height).toFloat(), 0f)
    }

}
