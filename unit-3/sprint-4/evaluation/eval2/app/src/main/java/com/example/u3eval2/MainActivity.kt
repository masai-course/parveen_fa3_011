package com.example.u3eval2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),Clicklistener {

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
        val songadapter=SongAdapter(responseModel,this)
        val linearLayoutManager=LinearLayoutManager(this)
        recycler.adapter=songadapter
        recycler.layoutManager=linearLayoutManager
    }

    override fun onclicked(position: Int, responseModel: Result) {
        val intent=Intent(this,MusicActivity::class.java)

        intent.putExtra("name",tvtrack.text.toString())
        intent.putExtra("artist",tvartist.text.toString())
        intent.putExtra("collection",tvcollection.text.toString())
        startActivity(intent)
    }
}