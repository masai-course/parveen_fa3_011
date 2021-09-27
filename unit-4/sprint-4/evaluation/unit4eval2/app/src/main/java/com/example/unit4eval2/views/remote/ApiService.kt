package com.example.unit4eval2.views.remote

import com.example.unit4eval2.views.remote.response.PizzaModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pizzas")
    fun posts(@Path("pizas")ID:String): Call<PizzaModel>
}