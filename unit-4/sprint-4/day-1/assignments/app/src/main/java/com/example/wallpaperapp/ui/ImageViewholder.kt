package com.example.wallpaperapp.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.databinding.ItemLayoutBinding
import com.example.wallpaperapp.remote.Photo
import com.example.wallpaperapp.remote.Src

class ImageViewholder(private val itview: ItemLayoutBinding, private val clickListener: ClickListener):RecyclerView.ViewHolder(itview.root) {


    // assigning views
    fun setviews(photo: Photo){
      Glide.with(itview.ivimage).load(photo.src.small).into(itview.ivimage)
        itview.cvcard.setOnClickListener {
            clickListener.onimageclick(adapterPosition, photo)
        }
    }
}