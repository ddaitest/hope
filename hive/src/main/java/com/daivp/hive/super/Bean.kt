package com.daivp.hive.`super`

import android.animation.TypeEvaluator

/**
 * Created by daining on 2018/4/23.
 */
data class Point(val x: Float, val y: Float)

class PointEvaluator : TypeEvaluator<Point> {
    override fun evaluate(p0: Float, startP: Point, endP: Point): Point {
        return startP.copy(x = startP.x + (endP.x - startP.x) * p0,
                y = startP.y + (endP.y - startP.y) * p0
        )
    }

}