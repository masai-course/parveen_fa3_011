package com.example.taskapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.R
import com.example.taskapp.apidata.Data
import com.example.taskapp.databinding.ItemLayoutBinding

class ItemAdapter(private val context: Context, private var itemlist: ArrayList<Data>): RecyclerView.Adapter<itemViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val itemLayoutBinding: ItemLayoutBinding= DataBindingUtil.inflate(inflater, R.layout.item_layout,parent, false)
        return itemViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val itemmodel= itemlist[position]
        holder.getitemview(itemmodel)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}