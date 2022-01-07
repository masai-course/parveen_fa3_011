package com.example.moviestask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.moviestask.R
import com.example.moviestask.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var activityMovieBinding:ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
activityMovieBinding=DataBindingUtil.setContentView(this,R.layout.activity_movie)

        Glide.with(activityMovieBinding.ivnowshoeing).load(intent.getStringExtra("movieImage")).into(activityMovieBinding.ivnowshoeing)
        activityMovieBinding.tvreleasedate1.text= "Relase Date: ${intent.getStringExtra("relDate1")}"
        activityMovieBinding.tvstoryline.text= intent.getStringExtra("story")
    }
}