package com.example.taskapp.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.apidata.Data
import com.example.taskapp.databinding.ItemLayoutBinding

class itemViewHolder(private val itemLayoutBinding: ItemLayoutBinding): RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun getitemview(data: Data){
        itemLayoutBinding.apply {
            tvid.text= "ID: ${data.user_id.toString()}"
            tvtitle.text= "Title: ${data.title}"
            tvbody.text= "Body: ${data.body}"
        }
    }
}