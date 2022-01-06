package com.example.moviestask.UI

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestask.apiresp.ComingSoon
import com.example.moviestask.databinding.PagerItemBinding

class pagerViewHolder(private val pagerview: PagerItemBinding):RecyclerView.ViewHolder(pagerview.root) {

  fun setPagerdata( comingsoon:ComingSoon){

        Glide.with(pagerview.ivpagerimg).load(comingsoon.posterurl).into(pagerview.ivpagerimg)

  }


}