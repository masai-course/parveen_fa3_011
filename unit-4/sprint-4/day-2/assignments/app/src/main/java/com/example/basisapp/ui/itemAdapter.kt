package com.example.basisapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.basisapp.R
import com.example.basisapp.data.Data
import com.example.basisapp.databinding.PagerLayoutBinding
import java.util.zip.Inflater

class itemAdapter(private val context: Context, private var itemlist: ArrayList<Data>, private val viewPager2: ViewPager2) :RecyclerView.Adapter<itemViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val layoutbinder: PagerLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.pager_layout, parent, false)
        return itemViewHolder(layoutbinder)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val model=itemlist[position]
        holder.setpagerdata(model)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}