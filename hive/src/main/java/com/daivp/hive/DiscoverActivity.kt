package com.daivp.hive

import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.transition.ChangeBounds
import android.support.transition.ChangeClipBounds
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_discover.*

class DiscoverActivity : AppCompatActivity() {
    val data = ArrayList<String>().also { it.addAll(listOf("A", "B", "C", "D", "E", "F")) }
    val adapter = ContentPagerAdapter(data, supportFragmentManager)
    var flag = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)
        vp_content.adapter = adapter
        tl_tab.tabMode = TabLayout.MODE_SCROLLABLE
        tl_tab.setTabTextColors(R.color.colorPrimary, R.color.colorAccent)
        tl_tab.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        ViewCompat.setElevation(tl_tab, 10F)
        tl_tab.setupWithViewPager(vp_content)
        button_add.setOnClickListener {
            adapter.add("_" + flag++)
        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            test_part1.isNestedScrollingEnabled = true
//        }
        ViewCompat.setNestedScrollingEnabled(test_part1, true)
//        ViewCompat.setNestedScrollingEnabled(test_part2,true)
        test_app_bar_layout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.d("DDAI", "verticalOffset = $verticalOffset  @ ${appBarLayout.totalScrollRange}")
            val shown = if (verticalOffset + appBarLayout.totalScrollRange > 50) {
                View.VISIBLE
            } else {
                View.GONE
            }
            if (test_bottom_layout.visibility != shown) {
                TransitionManager.beginDelayedTransition(test_bottom_layout, ChangeClipBounds())
                test_bottom_layout.visibility = shown
            }

        }
    }


}

class ContentPagerAdapter(private val tabs: ArrayList<String>, manager: FragmentManager) : FragmentPagerAdapter(manager) {
    override fun getItem(position: Int): Fragment {
        val bundle = Bundle().also {
            it.putString("TAB", tabs[position])
        }
        return TabContentFragment().also { it.arguments = bundle }
    }

    override fun getCount(): Int {
        return tabs.size
//        return 1
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabs[position]
    }

    fun add(tab: String) {
        tabs.add(tab)
        notifyDataSetChanged()
    }

}

