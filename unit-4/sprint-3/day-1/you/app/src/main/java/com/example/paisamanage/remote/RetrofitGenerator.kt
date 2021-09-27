package com.masai.taskmanagerapp.models.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitGenerator {

    private const val BASE_URL = "http://13.232.169.202:8080/users/"

    fun <S> createService(serviceClass: Class<S>?, token: String): S {
        val retrofit = getRetrofit(token)
        return retrofit.create(serviceClass)
    }

    private fun getRetrofit(token: String): Retrofit {
        val httpClient = OkHttpClient.Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .cache(null)
        httpClient.addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val request = chain.request()
            val newRequest = request.newBuilder()
            //newRequest.header("Content-Type", "application/json");
            //newRequest.header("Authorization", token);
            chain.proceed(newRequest.build())
        })

        val builder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
        return builder.client(httpClient.build()).build()
    }
}