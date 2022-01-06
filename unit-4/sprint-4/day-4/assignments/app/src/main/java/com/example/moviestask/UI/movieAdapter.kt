package com.example.moviestask.UI

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestask.apiresp.NowShowing
import com.example.moviestask.R
import com.example.moviestask.databinding.ItemLayoutBinding
import javax.inject.Inject

class movieAdapter (private val context: Context, private var movielist:ArrayList<NowShowing>):RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val itemLayoutBinding:ItemLayoutBinding = DataBindingUtil.inflate(inflater,R.layout.item_layout, parent , false)
        return MovieViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    val moviemodel=movielist[position]
    holder.getmovies(moviemodel)
    }

    override fun getItemCount(): Int {
    return movielist.size
    }
}