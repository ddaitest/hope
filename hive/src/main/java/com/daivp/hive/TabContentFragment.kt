package com.daivp.hive

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.page_coordinator.view.*

class TabContentFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.page_coordinator, null)
        view.page_title.text = arguments!!.getString("TAB")
        view.page_title.setOnClickListener {
            Snackbar.make(it, "HAHAHA", Snackbar.LENGTH_SHORT).show()
        }
        view.rv_content.layoutManager = LinearLayoutManager(context)
        view.rv_content.adapter = ContentAdapter(layoutInflater)
        return view
    }
}

