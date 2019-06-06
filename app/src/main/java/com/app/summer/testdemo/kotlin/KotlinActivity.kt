package com.app.summer.testdemo.kotlin

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.app.summer.testdemo.R
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity(), View.OnClickListener {

    private var str: String = ""
    private var int: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        tv_textView.text = "fdfdf"


        if (str != "") {
            Log.e("TAG", "str不是空字符串")
        } else {
            Log.e("TAG", "str是空字符串")
        }

        tv_textView.setOnClickListener(this)
//        tv_textView.setOnClickListener {
//            Toast.makeText(this,"卧槽",Toast.LENGTH_SHORT).show()

//        }


    }

    private fun fangfa(): String {
        return "dfsfs"
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_textView -> Toast.makeText(this, "卧槽", Toast.LENGTH_SHORT).show()
        }
    }
}
