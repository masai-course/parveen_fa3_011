package com.example.u3eval2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var responseModel: ResponseModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSearch.setOnClickListener {
            ApiCall()
        }
    }
    fun ApiCall(){
        val apiClient=Network.getretrofitinstance().create(ApiClient::class.java)
        apiClient.posts(etname.text.toString()).enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                responseModel=response.body()!!
                setrecyclerview()
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Call Fail",Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun setrecyclerview(){
        val songadapter=SongAdapter(responseModel)
        val linearLayoutManager=LinearLayoutManager(this)
        recycler.adapter=songadapter
        recycler.layoutManager=linearLayoutManager
    }
}