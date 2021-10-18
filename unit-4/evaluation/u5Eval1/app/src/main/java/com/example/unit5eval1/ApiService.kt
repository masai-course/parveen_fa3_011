package com.example.unit5eval1

import com.example.unit5eval1.data.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("people?page")
    suspend fun getposts (@Query("page") page:Int): Call<ResponseModel>
}