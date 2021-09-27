package com.example.unit4eval2.views.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object{
        private val httploggingInterceptr=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        fun getinstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/shivarajp/04af4846333e3c61a8d84d310915c75d/raw/a8a1bd18d7ca7f59dc56784b211044864beba831/")
                .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient.Builder()
                    .addInterceptor(httploggingInterceptr).build()).build()
        }
    }

}