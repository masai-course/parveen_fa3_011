package com.example.wallpaperapp.api

import com.example.wallpaperapp.remote.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface Apiservice {

    @GET("v1/search?query=animal")

    suspend fun getResponse(@Header("Authorization")token: String): Response


}