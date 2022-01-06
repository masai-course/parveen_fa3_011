package com.example.moviestask.UI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.moviestask.Data.ComingSoon
import com.example.moviestask.Data.NowShowing
import com.example.moviestask.R

class pageradapter(private val context: Context, private var movielist:ArrayList<ComingSoon>, private val viewPager2: ViewPager2):RecyclerView.Adapter<pagerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pagerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.pager_item,parent,false)
        return pagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: pagerViewHolder, position: Int) {
        val model=movielist[position]
        holder.setPagerdata(model)
    }

    override fun getItemCount(): Int {
        return movielist.size
    }
}