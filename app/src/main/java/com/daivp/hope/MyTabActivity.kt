package com.daivp.hope

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_my_tab.*

class MyTabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_tab)
        viewpager.adapter = MyViewPagerAdapter(supportFragmentManager).apply {
            addOne("AAA")
            addOne("BBB")
            addOne("CCC")
            addOne("DDD")
        }
        tabLayout.setupWithViewPager(viewpager)
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_menu_manage)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_menu_camera)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_menu_gallery)
        tabLayout.getTabAt(3)?.setIcon(R.drawable.ic_menu_share)
    }

    class MyViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        val fragments = ArrayList<Fragment>()
        val titles = ArrayList<String>()

        override fun getItem(position: Int) = fragments[position]

        override fun getCount() = fragments.size

        override fun getPageTitle(position: Int) = titles[position]
        fun addOne(name: String) {
            val f = DListFragment()
            f.arguments = Bundle().apply { putString("name", name) }
            fragments.add(f)
            titles.add(name)
        }

    }
}
