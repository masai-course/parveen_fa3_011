package com.example.unit5eval1.views

import com.example.unit5eval1.data.ResponseModel
import com.example.unit5eval1.data.ResponseModelItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("people?page")
    suspend fun getposts (@Query("page") page:Int): ResponseModel
}