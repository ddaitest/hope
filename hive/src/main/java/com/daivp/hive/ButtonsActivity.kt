package com.daivp.hive

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_buttons.*
import java.io.File
import java.io.FileOutputStream

class ButtonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)

        rl_test.setOnClickListener { }
        rl_test2.setOnClickListener { }
        rl_test3.setOnClickListener { }
        rl_test4.setOnClickListener { }
        rl_test5.setOnClickListener { }
        rl_test6.setOnClickListener { }

        textView2.setOnClickListener { }
        textView3.setOnClickListener { }
        imageView.setOnClickListener { }
        imageView2.setOnClickListener { }
        imageView3.setOnClickListener { }
        imageView4.setOnClickListener { }
        imageView5.setOnClickListener { }
        imageView6.setOnClickListener { }
        imageView7.setOnClickListener { }
    }

}


fun File.appendFile(target: File) {
    this.outputAppendStream().use { output ->
        target.inputStream().use { input ->
            input.copyTo(output, DEFAULT_BUFFER_SIZE)
        }
    }
}

inline fun File.outputAppendStream(): FileOutputStream {
    return FileOutputStream(this, true)
}