package com.example.scopefunyou

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val datalist:ResponseModel,val itemclicklistener: itemclickListener):RecyclerView.Adapter<PostViewholder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return PostViewholder(view,itemclicklistener)
    }

    override fun onBindViewHolder(holder: PostViewholder, position: Int) {
        val model: Data =datalist.data[position]
        holder.setdata(model)

    }

    override fun getItemCount(): Int {
        return datalist.data.size
    }
}