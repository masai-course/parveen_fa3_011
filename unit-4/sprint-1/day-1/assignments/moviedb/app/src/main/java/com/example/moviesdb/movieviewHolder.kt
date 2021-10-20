package com.example.moviesdb

import android.app.Activity
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdb.databinding.ItemLayoutBinding

class movieviewHolder(private val itemLayoutBinding: ItemLayoutBinding):RecyclerView.ViewHolder(itemLayoutBinding.root) {



    fun setdata(response:ResponseModel){
        itemLayoutBinding.tvname.text=response.title
        itemLayoutBinding.tvlanguge.text=response.original_language
        itemLayoutBinding.tvcountry.text=response.production_countries[adapterPosition].name
        itemLayoutBinding.tvcompany.text=response.production_companies[adapterPosition].name

    }


}