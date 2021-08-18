package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val responseModel: ResponseModel):RecyclerView.Adapter<postviewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postviewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
             return postviewHolder(view)
    }

    override fun onBindViewHolder(holder: postviewHolder, position: Int) {
        val model:ResponseModelItem=responseModel[position]
        holder.setdata(model)
    }

    override fun getItemCount(): Int {
        return responseModel.size
    }
}