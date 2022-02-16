package com.example.postapplication.service

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    val gson =  GsonBuilder()
        .setLenient()
        .create()

    val httploggingintercepter= HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    fun getretrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl( "https://twiclo.com/").addConverterFactory(
                GsonConverterFactory.create(gson))
            .client(OkHttpClient.Builder().addInterceptor(httploggingintercepter).build()).build()
    }


   // fun getapiservice() = getretrofit().create(apiservice::class.java)
}