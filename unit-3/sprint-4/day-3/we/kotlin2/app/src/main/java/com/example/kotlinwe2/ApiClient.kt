package com.example.kotlinwe2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("/api/users/{ID}")
    fun getposts(@Path("ID")ID:Int):Call<ResponseDTO>
}