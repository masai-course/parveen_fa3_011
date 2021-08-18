package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var responseModel:ResponseModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPost.setOnClickListener {
            CallApi()
        }
    }
    private fun CallApi(){
        val apiClient=Network.getretrofitinstance().create(ApiClient::class.java)
        apiClient.getposts(etPostId.text.toString().toInt())
            .enqueue(object:Callback<ResponseModel>{
                override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                        responseModel= response.body()!!
                    setRecyclerview()
                }

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

                }

            })
    }
    private fun setRecyclerview(){
        val postAdapter=PostAdapter(responseModel)
        val linearLayoutManager=LinearLayoutManager(this)
        recyclerView.adapter=postAdapter
        recyclerView.layoutManager=linearLayoutManager
    }
}