package com.example.moviestask.UI

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestask.apiresp.NowShowing
import com.example.moviestask.databinding.ItemLayoutBinding

class MovieViewHolder(private val moviebinding:ItemLayoutBinding):RecyclerView.ViewHolder(moviebinding.root) {

    fun getmovies(nowShowing: NowShowing){

            Glide.with(moviebinding.ivimage).load(nowShowing.posterurl).into(moviebinding.ivimage)

    }
}