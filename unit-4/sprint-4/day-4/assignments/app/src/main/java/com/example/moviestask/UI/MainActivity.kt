package com.example.moviestask.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviestask.Data.ComingSoon
import com.example.moviestask.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var pageradapter: pageradapter
    var movielist=ArrayList<ComingSoon>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager2=VPviewpager
        pageradapter=pageradapter(this,movielist,pager2)
        pager2.adapter=pageradapter
    }
}