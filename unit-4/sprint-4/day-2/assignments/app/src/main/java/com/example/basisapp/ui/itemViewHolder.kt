package com.example.basisapp.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.basisapp.data.Data
import com.example.basisapp.databinding.PagerLayoutBinding

class itemViewHolder(private val pagerLayoutBinding: PagerLayoutBinding) : RecyclerView.ViewHolder(pagerLayoutBinding.root) {

    fun setpagerdata(data: Data){
        pagerLayoutBinding.apply {
            textno.text=data.id
            textno2.text=data.text
        }
    }
}