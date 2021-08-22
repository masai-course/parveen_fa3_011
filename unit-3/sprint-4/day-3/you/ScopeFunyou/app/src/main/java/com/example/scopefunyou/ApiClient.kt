package com.example.scopefunyou

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("api/users")
    fun getposts(@Query("users")postId:Int):retrofit2.Call<ResponseModel>
}