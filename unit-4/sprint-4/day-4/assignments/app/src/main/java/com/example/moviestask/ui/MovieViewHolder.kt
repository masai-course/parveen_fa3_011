package com.example.moviestask.ui

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestask.apiresp.NowShowing
import com.example.moviestask.databinding.ItemLayoutBinding

class MovieViewHolder(private val moviebinding:ItemLayoutBinding, private val clickListener: ClickListener):RecyclerView.ViewHolder(moviebinding.root) {


    // setting views of item_layout
    fun getmovies(nowShowing: NowShowing){

            Glide.with(moviebinding.ivimage).load(nowShowing.posterurl).into(moviebinding.ivimage)
             moviebinding.ivimage.setOnClickListener {
                 clickListener.onmovieclick(adapterPosition,nowShowing)
             }
    }
}