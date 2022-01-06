package com.example.moviestask.UI

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestask.Data.NowShowing
import kotlinx.android.synthetic.main.item_layout.view.*

class MovieViewHolder(val view:View):RecyclerView.ViewHolder(view) {

    fun getmovies(nowShowing: NowShowing){
        view.apply {
            Glide.with(this).load(nowShowing.posterurl).into(ivimage)
        }
    }
}