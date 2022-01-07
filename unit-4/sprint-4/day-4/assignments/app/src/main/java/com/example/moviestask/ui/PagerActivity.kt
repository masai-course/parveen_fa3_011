package com.example.moviestask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.moviestask.R
import com.example.moviestask.databinding.ActivityPagerBinding

class PagerActivity : AppCompatActivity() {

    private lateinit var pagerbinding: ActivityPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
pagerbinding= DataBindingUtil.setContentView(this, R.layout.activity_pager)
     Glide.with(pagerbinding.ivcomingsoon).load(intent.getStringExtra("pagerImage")).into(pagerbinding.ivcomingsoon)
     pagerbinding.tvreleasedate.text= "Relase Date: ${intent.getStringExtra("relDate")}"
     pagerbinding.tvreleasedisc.text= "${intent.getStringExtra("disc")}"
    }


}