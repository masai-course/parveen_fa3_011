package com.example.moviesdb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(val response:List<ResponseModel>):RecyclerView.Adapter<movieviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieviewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return movieviewHolder(view)    }

    override fun onBindViewHolder(holder: movieviewHolder, position: Int) {
        val model=response[position]
        holder.setdata(model)
    }

    override fun getItemCount(): Int {
return response.size
    }
}