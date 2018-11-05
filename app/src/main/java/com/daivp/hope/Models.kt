package com.daivp.hope

/**
 * Created by daining on 2018/2/19.
 */
data class Task(
        val name: String,
        val mobile: String,
        val time_start: String,
        val time_end: String,
        val addr_start: String,
        val addr_end: String,
        val remark: String)

fun Task.clone() :Task = Task(name, mobile, time_start, time_end, addr_start, addr_end, remark)