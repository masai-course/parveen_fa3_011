package com.example.kutukiassignment.apii

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    val httploggingintercepter= HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun getretrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl( "http://www.mocky.io/").addConverterFactory(
                GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(httploggingintercepter).build()).build()
    }


    fun getapiservice(retrofit: Retrofit) :ApiService = retrofit.create(ApiService::class.java)


}