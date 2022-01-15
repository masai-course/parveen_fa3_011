package com.example.wallpaperapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.ItemLayoutBinding
import com.example.wallpaperapp.remote.Photo
import java.util.zip.Inflater

class ImageAdapter(val context: Context, private var imagelist: ArrayList<Photo>, private val clickListener: ClickListener): RecyclerView.Adapter<ImageViewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewholder {
        val inflater= LayoutInflater.from(parent.context)
        val itemLayoutBinding:ItemLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.item_layout, parent,false)
        return ImageViewholder(itemLayoutBinding, clickListener)
    }

    override fun onBindViewHolder(holder: ImageViewholder, position: Int) {
        var model =imagelist[position]
        holder.setviews(model)
    }

    override fun getItemCount(): Int {
            return imagelist.size
    }
}