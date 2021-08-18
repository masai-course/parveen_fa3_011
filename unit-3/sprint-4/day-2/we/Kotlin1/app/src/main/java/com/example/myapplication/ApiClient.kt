package com.example.myapplication

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("comments")
    fun getposts(@Query("postId")postId:Int):retrofit2.Call<ResponseModel>
}