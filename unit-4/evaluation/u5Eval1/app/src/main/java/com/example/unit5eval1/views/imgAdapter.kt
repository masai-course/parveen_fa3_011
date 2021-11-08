package com.example.unit5eval1.views

import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.unit5eval1.R
import com.example.unit5eval1.data.ResponseModel
import com.example.unit5eval1.data.ResponseModelItem

class imgAdapter:PagingDataAdapter<ResponseModelItem, getviewhlder>(diffUtil) {

    companion object{
        val diffUtil=object :DiffUtil.ItemCallback<ResponseModelItem>(){
            override fun areItemsTheSame(oldItem:ResponseModelItem, newItem: ResponseModelItem): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResponseModelItem,
                newItem: ResponseModelItem
            ): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onBindViewHolder(holder: getviewhlder, position: Int) {
        val listofdata=ResponseModel()[position]
        listofdata?.let {
            holder.setdata(it)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): getviewhlder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return getviewhlder(view)
    }
}