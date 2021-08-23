package com.example.u3eval2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(val responselist:ResponseModel, val clicklistener: Clicklistener):RecyclerView.Adapter<SongViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return SongViewHolder(view,clicklistener)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val model:Result=responselist.results[position]
        holder.setdata(model)
    }

    override fun getItemCount(): Int {
        return  responselist.results.size
    }
}