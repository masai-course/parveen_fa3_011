package com.example.moviestask.ui

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestask.apiresp.ComingSoon
import com.example.moviestask.databinding.PagerItemBinding

class pagerViewHolder(private val pagerview: PagerItemBinding, private val clickListener: ClickListener):RecyclerView.ViewHolder(pagerview.root) {


    // pager_item lauout views set
  fun setPagerdata( comingsoon:ComingSoon){

        Glide.with(pagerview.ivpagerimg).load(comingsoon.posterurl).into(pagerview.ivpagerimg)
        pagerview.ivpagerimg.setOnClickListener {
            clickListener.onPagerclick(adapterPosition,comingsoon)
        }
  }


}