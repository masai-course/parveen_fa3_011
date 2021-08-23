package com.example.u3eval2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("search")
    fun posts(@Query("term")Id:String):Call<ResponseModel>
}