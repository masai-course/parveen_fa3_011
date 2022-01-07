package com.example.moviestask.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.moviestask.apiresp.ComingSoon
import com.example.moviestask.R
import com.example.moviestask.databinding.PagerItemBinding

class pageradapter (private val context: Context, private var pagerlist:ArrayList<ComingSoon>, private val viewPager2: ViewPager2, private val clickListener: ClickListener):RecyclerView.Adapter<pagerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pagerViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val ItemLayoutBinder:PagerItemBinding = DataBindingUtil.inflate(inflater , R.layout.pager_item,parent, false )
        return pagerViewHolder(ItemLayoutBinder, clickListener)
    }

    override fun onBindViewHolder(holder: pagerViewHolder, position: Int) {
        val model=pagerlist[position]
        holder.setPagerdata(model)


        //for infinite pager loop
        if (position==pagerlist.size-2){
            viewPager2.post(runable)
        }
    }

    override fun getItemCount(): Int {
        return pagerlist.size
    }


  // initialis runanble for infinite loop
    private var runable= Runnable {
         kotlin.run {
             pagerlist.addAll(pagerlist)
             notifyDataSetChanged()
        }

    }
}