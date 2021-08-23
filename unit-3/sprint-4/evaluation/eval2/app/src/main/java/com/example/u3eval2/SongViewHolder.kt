package com.example.u3eval2

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class SongViewHolder(private val view:View,val clicklistener: Clicklistener):RecyclerView.ViewHolder(view) {


    fun setdata(datalist:Result){
        view.apply {
            Picasso.get().load(datalist.artworkUrl60).into(ivimage)
            tvtrack.text=datalist.trackName
            tvartist.text=datalist.artistName
            tvcollection.text=datalist.collectionName
            rela.setOnClickListener {
                clicklistener.onclicked(adapterPosition,datalist)
            }
        }
    }
}