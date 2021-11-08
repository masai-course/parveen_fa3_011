package com.example.u5eval2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.u5eval2.data.Article

class NewsAdapter(val newslist:List<Article>):RecyclerView.Adapter<newsViewHOlder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsViewHOlder {
val view=LayoutInflater.from(parent.context).inflate(R.layout.newslayout,parent,false)
    return newsViewHOlder(view)
    }

    override fun onBindViewHolder(holder: newsViewHOlder, position: Int) {
      val news=newslist[position]
news.let {
    holder.setdata(it)
}    }

    override fun getItemCount(): Int {
return newslist.size   }


}