package com.example.navifragyou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        intent?.run {
            tv1.text=getStringExtra("event")
            tv2.text=getStringExtra("discription")
            tv3.text=getStringExtra("stdate")
            tv4.text=getStringExtra("edate")
            tv5.text=getStringExtra("sttime")
            tv6.text=getStringExtra("etime")
            tv7.text="${getIntExtra("price",0)}"
        }
    }
}