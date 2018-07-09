package com.daivp.hope

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.TextView
import com.daivp.hope.common.BasePopupWindow
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.home_filter.view.*
import kotlinx.android.synthetic.main.item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var viewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        swipe_ly.setOnRefreshListener { viewModel.load() }

        rc_list.layoutManager = LinearLayoutManager(this)
        val adapter = HomeAdapter(layoutInflater, listener = {
            //TODO got detail
        })
        rc_list.adapter = adapter
        viewModel.tasks.observe(this, Observer {
            it?.let { adapter.setData(it) }
        })

        viewModel.loading.observe(this, Observer {
            it?.let {
                swipe_ly.isRefreshing = it
            }
        })
        viewModel.load()

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.find_passenger -> {
                // Handle the camera action
            }
            R.id.find_driver -> {

            }
            R.id.publish_driver -> {
                startActivity(Intent(this@HomeActivity, PublishActivity::class.java))
            }
            R.id.publish_passenger -> {
                startActivity(Intent(this@HomeActivity, PublishActivity::class.java))
            }
            R.id.nav_share -> {

            }
            R.id.nav_about -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_filter -> {
                shareWindow().showAsDropDown(cl_parent, Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareWindow(): BasePopupWindow {
        val window = BasePopupWindow(this@HomeActivity)
        val parent = layoutInflater.inflate(R.layout.home_filter, null)
        window.contentView = parent
        parent.bt_cancel.setOnClickListener { window.dismiss() }
        parent.bt_ok.setOnClickListener { window.dismiss() }
        window.update()
        return window
    }


    class HomeAdapter(private val inflater: LayoutInflater, private var items: ArrayList<Task> = ArrayList(), private val listener: (Task) -> Unit) : RecyclerView.Adapter<HomeAdapter.MyHolder>() {
        private val format = SimpleDateFormat("MM月dd日 HH:mm:ss", Locale.CHINA)

        override fun onBindViewHolder(holder: MyHolder, position: Int) {
            val item = items[position]
            holder.from.text = item.start
            holder.to.text = item.end
            holder.time.text = format.format(Date(item.time))
            holder.remark.text = item.remark
            holder.itemView.setOnClickListener { listener.invoke(items[position]) }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
            return MyHolder(inflater.inflate(R.layout.item, parent, false))
        }

        override fun getItemCount() = items.size

        fun setData(newItems: List<Task>) {
            val tmp = ArrayList<Task>(newItems.size)
            newItems.forEach { tmp.add(it.clone()) }
            DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun getOldListSize(): Int = items.size

                override fun getNewListSize(): Int = newItems.size

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return items[oldItemPosition] == newItems[newItemPosition]
                }

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = items[oldItemPosition].id == (newItems[newItemPosition].id)
            }).apply {
                dispatchUpdatesTo(this@HomeAdapter)
            }
            items.clear()
            items.addAll(tmp)
        }

        class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
            val from: TextView = view.tv_start
            val to: TextView = view.tv_end
            val time: TextView = view.tv_time
            val remark: TextView = view.tv_remark
        }
    }
}

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    val tasks = MutableLiveData<List<Task>>().also { it.value = ArrayList() }
    val loading = MutableLiveData<Boolean>().also { it.value = false }

    fun load() {
        thread {
            Thread.sleep(2000)
            val ts = ArrayList<Task>()
            (1..10).forEach {
                ts.add(Task("", "北京$it", "固安$it", System.currentTimeMillis(), "hahah..."))
            }
            tasks.postValue(tasks.value?.plus(ts))
            loading.postValue(false)
        }

    }
}