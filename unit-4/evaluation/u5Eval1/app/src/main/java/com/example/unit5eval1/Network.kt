package com.example.unit5eval1

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    private fun getinstance():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient()).build()
    }

    fun getApi():ApiService= getinstance().create(ApiService::class.java)

}