package com.daivp.hope

/**
 * Created by daining on 2018/2/19.
 */
data class Task(val id: String, val start: String, val end: String, val time: Long, val remark: String)

fun Task.clone() :Task = Task(id, start, end, time, remark)