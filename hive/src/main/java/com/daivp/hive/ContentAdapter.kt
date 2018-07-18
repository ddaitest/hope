package com.daivp.hive

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_coordinator.view.*

class ContentAdapter(val inflater: LayoutInflater) : RecyclerView.Adapter<ContentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(inflater.inflate(R.layout.item_coordinator, parent, false))
    }

    override fun getItemCount() = 30

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.title.text = "< $position >"
    }

}

class ContentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.test_tv11!!
}