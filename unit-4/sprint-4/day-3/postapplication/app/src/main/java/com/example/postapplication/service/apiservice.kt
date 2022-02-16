package com.example.postapplication.service


import com.example.postapplication.respapi.OrderStatu
import com.example.postapplication.respapi.ResModel
import retrofit2.Call
import retrofit2.http.*

interface apiservice {

    @POST("api/method/chatbotGetOrderStatus.inc.php")
     fun getdata(
       @Header ("accessToken") accessToken: String,
       @Header ("accountId") accountId: Int,
       @Header ("orderId") orderId: Int,


    ): Call<ResModel>
}