package com.example.moviestask.UI

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestask.Data.NowShowing
import com.example.moviestask.R

class movieAdapter(private val context: Context, private var movielist:ArrayList<NowShowing>):RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    val moviemodel=movielist[position]
    holder.getmovies(moviemodel)
    }

    override fun getItemCount(): Int {
    return movielist.size
    }
}