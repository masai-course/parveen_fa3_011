package com.example.taskapp.remote

import com.example.taskapp.apidata.ResponseModel
import retrofit2.http.GET

interface apiService {

    @GET("public/v1/posts")
    suspend fun getResult() : ResponseModel
}