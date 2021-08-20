package com.example.scopefunyou

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("users")
    fun getposts(@Query("postId")postId:Int):retrofit2.Call<ResponseModel>



}