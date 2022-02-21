package com.example.multiplelayout.apiclint

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CancelNetwork {

    val httploggingintercepter= HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    fun getretrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl( "https://twiclo.com/").addConverterFactory(
                GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(httploggingintercepter).build()).build()
    }


    fun getapiservice() = getretrofit().create(apiService::class.java)

}