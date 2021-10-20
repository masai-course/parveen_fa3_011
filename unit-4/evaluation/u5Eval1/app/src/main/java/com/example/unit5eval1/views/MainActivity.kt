package com.example.unit5eval1.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unit5eval1.R
import com.example.unit5eval1.data.ResponseModel
import com.example.unit5eval1.data.ResponseModelItem
import com.example.unit5eval1.viewModel.imgViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodell: imgViewModel
    private lateinit var imgAdapter: imgAdapter
    private lateinit var recycler:RecyclerView
    private val res=ResponseModelItem()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler=findViewById(R.id.recycler)
        viewmodell=ViewModelProvider(this).get(imgViewModel::class.java)
        setadapter()
        viewmodell.getapidata().observe(this,  {
            it?.let {
                CoroutineScope(Main).launch {
                    imgAdapter.submitData(it)
                }}
        })
    }

    private fun setadapter(){
        imgAdapter= imgAdapter()
        val layoutManager=LinearLayoutManager(this)
        recycler.layoutManager=layoutManager
        recycler.adapter=imgAdapter

    }
}