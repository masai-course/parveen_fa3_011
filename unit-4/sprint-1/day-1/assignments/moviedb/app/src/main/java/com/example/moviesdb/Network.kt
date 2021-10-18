package com.example.moviesdb

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {


    companion object{
        private val httpLoggingInterceptor= HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        fun getretrofitinstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl( "https://api.themoviedb.org/3/").addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).build()
        }
    }

}