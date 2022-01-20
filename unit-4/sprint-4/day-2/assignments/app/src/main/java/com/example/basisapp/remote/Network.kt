package com.example.basisapp.remote

import com.google.gson.GsonBuilder
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
    //  val gson= GsonBuilder().setLenient().create()
    @Singleton
    @Provides
    fun getretrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl( "https://gist.githubusercontent.com/").addConverterFactory(
                customgson())
            .client(OkHttpClient.Builder().addInterceptor(httploggingintercepter).build()).build()
    }

     @Singleton
     @Provides
    fun getapiservice(retrofit: Retrofit) :ApiService = retrofit.create(ApiService::class.java)

}