package com.example.wallpaperapp.api

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn (SingletonComponent::class)
@Module
object Network {

    val httpLoggingInterceptor =HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun getretrofitInstance():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.pexels.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).build()

    }

    @Singleton
    @Provides
    fun getapi(retrofit: Retrofit):Apiservice = retrofit.create(Apiservice::class.java)





}