package com.example.scopefunyou

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFrag : Fragment(R.layout.fragment_detail ) {

     private lateinit var responseModel:ResponseModel
     interface itemclicklistener:itemclickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ApiCall()
    }
    fun ApiCall(){
          val apiClient=Network.getretrofitinstance().create(ApiClient::class.java)
        apiClient.getposts(2).enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                responseModel= response.body()!!
                setRecyclerview()
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
            Toast.makeText(context,"failed",Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun setRecyclerview(){

        val postAdapter=PostAdapter(responseModel,context)
        val linearLayoutManager= LinearLayoutManager(context)
        recycle.adapter=postAdapter
        recycle.layoutManager=linearLayoutManager
    }




}


