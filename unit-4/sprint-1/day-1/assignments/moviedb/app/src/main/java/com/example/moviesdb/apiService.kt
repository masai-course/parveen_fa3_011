package com.example.moviesdb

import retrofit2.Call
import retrofit2.http.GET

interface apiService {

    @GET("movie/550?api_key=1e7fc1c86c01d9dbe8ea92b1ac3e9fb9")
    fun getpost():Call<ResponseModel>


}