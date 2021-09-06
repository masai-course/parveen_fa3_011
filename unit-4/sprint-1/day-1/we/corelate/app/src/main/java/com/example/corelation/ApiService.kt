package com.example.corelation

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/users/{userId}")
    fun getUser(@Path("userId") userId: Int): Call<ResponseModel?>?
}