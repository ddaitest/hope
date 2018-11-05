package com.daivp.hive

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_easy_post.*
import kotlinx.android.synthetic.main.activity_test.view.*

class EasyPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_post)
//        button2.setOnClickListener {
//            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("welike://com.redefine.welike/main/home?page_name=post_detail&pid=1c6abba2-6e53-45b1-80d6-665927238a1a")))
//        }
        val data = arrayListOf("welike://com.redefine.welike/main/home?page_name=post_detail&pid=1c6abba2-6e53-45b1-80d6-665927238a1a")
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = TestAdapter(data, layoutInflater)
        {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
        }
        lottie.setAnimation("temp.json")
        button2.setOnClickListener {
//            lottie.playAnimation()
            test_view.setScaleType(TestView.ScaleType.FILL)
            test_view.setContentWidth(600)
            test_view.setContentHeight(300)
            test_view.updateTextureViewSize()
        }
        button3.setOnClickListener {
//            lottie.setMaxProgress(0.75f)
//            lottie.playAnimation()
        }
    }
}

class TestAdapter(val data: ArrayList<String> = ArrayList(), val layoutInflater: LayoutInflater, val click: (String) -> Unit) : RecyclerView.Adapter<TestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TestViewHolder(layoutInflater.inflate(R.layout.item_test, parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.title.text = data[position]
        holder.button.setOnClickListener {

            click(data[position])
        }
    }

}

class TestViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.test_tv1
    val button = view.test_button
}
