package com.example.moviestask.remote

import com.example.moviestask.apiresp.ResponseModel
import retrofit2.http.GET

interface ApiService {

    @GET("Dcosta2205/cd3bf4cfdf6911fb26ae95672adb468e/raw/62d68fac146598cdba379317011ac9aa1aca8621/movies_db")
    suspend fun getresult():ResponseModel


}