package com.example.taskapp.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Network {



    val httploggingintercepter= HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun getretrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl( " https://gorest.co.in/").addConverterFactory(
                GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(httploggingintercepter).build()).build()
    }

    @Singleton
    @Provides
    fun getapiservice(retrofit: Retrofit) :apiService = retrofit.create(apiService::class.java)
}