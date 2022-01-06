package com.example.u5eval2.viewModel

import com.example.u5eval2.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceNetwork {

    fun getretro()=Retrofit.Builder().baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getapi()= getretro().create(ApiService::class.java)
}