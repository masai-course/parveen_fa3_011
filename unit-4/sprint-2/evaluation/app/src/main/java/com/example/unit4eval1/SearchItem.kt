package com.example.unit4eval1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_searchitem.*

class SearchItem : AppCompatActivity() {

    lateinit var itemAdapter: ItemAdapter
    private val itemlist= mutableListOf<Model>()
    val dbhandler=DataHandler(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_searchitem)

        mbtnsrh.setOnClickListener {
         itemlist.addAll(dbhandler.findtask())
        }



        itemAdapter= ItemAdapter(this,itemlist)
        Recycler.layoutManager=LinearLayoutManager(this)
        Recycler.adapter=itemAdapter

    }
}