package com.example.moviesdb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdb.databinding.ItemLayoutBinding

class MovieAdapter(val response:List<ResponseModel>):RecyclerView.Adapter<movieviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieviewHolder {
        val view= LayoutInflater.from(parent.context)
        val itemLayoutBinding=ItemLayoutBinding.inflate(view,parent,false)
        return movieviewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: movieviewHolder, position: Int) {
        val model=response[position]
        holder.setdata(model)
    }

    override fun getItemCount(): Int {
      return response.size
    }
}