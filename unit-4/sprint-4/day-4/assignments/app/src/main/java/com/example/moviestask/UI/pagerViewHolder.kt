package com.example.moviestask.UI

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestask.Data.ComingSoon
import kotlinx.android.synthetic.main.pager_item.view.*

class pagerViewHolder(val view: View):RecyclerView.ViewHolder(view) {

  fun setPagerdata( comingsoon:ComingSoon){
    view.apply {
        Glide.with(this).load(comingsoon.posterurl).into(ivpagerimg)
    }
  }


}