package com.daivp.hive

import android.animation.*
import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_super_like.*
import com.daivp.hive.`super`.Point
import com.daivp.hive.`super`.PointEvaluator

/**
 * TODO generate random View
 * TODO generate random Animator
 * TODO generate start & stop
 * TODO generate recycle view
 *
 *
 */
class SuperLikeActivity : AppCompatActivity() {

    var x = 1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_like)
        bta.setOnClickListener {
            anim5()
        }
        btb.setOnClickListener {
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notify = NotificationCompat.Builder(applicationContext, "1")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("AAAA")
                    .setContentText("BBBBBB")
                    .setAutoCancel(true)
                    .setTicker("123")
                    .build()
            manager.notify(x++, notify)
        }
    }

    fun anim5() {
        iv.animate().x(500f).y(500f).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
            }
        })
    }

    fun anim4() {
        val anim = ObjectAnimator.ofFloat(iv, "translationX", 0f, 500f)
        anim.duration = 1000
        anim.start()
    }

    fun anim3() {
        val anim = ObjectAnimator.ofFloat(iv, "alpha", 1f, 0.1f, 1f, 0.1f, 1f)
        anim.duration = 3000
        anim.start()
    }

    fun anim1() {
        val anim = ValueAnimator.ofInt(100, 300)
        anim.duration = 1000
        anim.startDelay = 500
        anim.repeatCount = 0
        anim.repeatMode = ValueAnimator.RESTART
        anim.addUpdateListener { animation ->
            val currentValue = animation.animatedValue as Int
            System.out.println(currentValue)
            iv.layoutParams.width = currentValue
            iv.requestLayout()
        }
        anim.start()
    }

    fun anim2() {

        val anim = ValueAnimator.ofObject(PointEvaluator(), Point(1f, 1f), Point(500f, 1000f))
        anim.duration = 1000
        anim.startDelay = 500
        anim.repeatCount = 0
        anim.repeatMode = ValueAnimator.RESTART
        anim.addUpdateListener { animation ->
            val cp = animation.animatedValue as Point
            iv.x = cp.x
            iv.y = cp.y
            iv.requestLayout()
        }
        anim.start()
    }


}
