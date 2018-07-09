package com.daivp.hope

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dlist.view.*

/**
 * Created by daining on 2018/2/22.
 */
class DListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_dlist, container, false)
        view.textView.text = arguments?.getString("name")
        return view
    }
}