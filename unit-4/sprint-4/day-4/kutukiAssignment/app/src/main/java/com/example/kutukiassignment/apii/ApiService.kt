package com.example.kutukiassignment.apii

import com.example.kutukiassignment.firstapi.FirstModel
import com.example.kutukiassignment.firstapi.Response
import retrofit2.http.GET

interface ApiService {


    @GET("v2/5e2bebd23100007a00267e51")
    suspend fun getresult():FirstModel
}