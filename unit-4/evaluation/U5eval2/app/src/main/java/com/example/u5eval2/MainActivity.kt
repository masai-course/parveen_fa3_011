package com.example.u5eval2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.u5eval2.data.Article
import com.example.u5eval2.data.ResponseModel
import com.example.u5eval2.viewModel.ServiceNetwork

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var recyclerView: RecyclerView
    private val resp=ArrayList<Article>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recycler)

    }
    private fun apicall(){
        ServiceNetwork.getapi().getposts().subs
    }

    private fun setadaptr(){
        newsAdapter= NewsAdapter(resp)
        val layoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=newsAdapter
    }
}