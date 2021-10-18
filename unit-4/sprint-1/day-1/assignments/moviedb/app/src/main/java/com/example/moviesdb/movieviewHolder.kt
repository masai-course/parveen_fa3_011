package com.example.moviesdb

import android.app.Activity
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdb.databinding.ItemLayoutBinding

class movieviewHolder(val view:View):RecyclerView.ViewHolder(view) {

    var activitybinding:ItemLayoutBinding=DataBindingUtil.setContentView(Activity(),R.layout.item_layout)


    fun setdata(response: ResponseModel){
        activitybinding.tvname.text=response.title
        activitybinding.tvlanguge.text=response.original_language
        activitybinding.tvcountry.text=response.production_countries[position].name
        activitybinding.tvcompany.text=response.production_companies[position].name

    }


}