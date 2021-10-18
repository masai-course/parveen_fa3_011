package com.example.moviesdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var responsemodel:List<ResponseModel>
    private lateinit var  recycler:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler=findViewById(R.id.recycler)
        ApiCall()

    }

    fun ApiCall(){
        val apiClient=Network.getretrofitinstance().create(apiService::class.java)
        apiClient.getpost().enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                responsemodel= listOf(response.body()) as List<ResponseModel>
                setrecyclerview()
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Call Fail", Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun setrecyclerview(){
        val movieAdapter=MovieAdapter(responsemodel)
        val linearLayoutManager= LinearLayoutManager(this)
        recycler.adapter=movieAdapter
        recycler.layoutManager=linearLayoutManager
    }
}