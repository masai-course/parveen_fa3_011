package com.example.unit4eval2.views.remote.response

data class PizzaModel(
    val crusts: List<Crust>,
    val defaultCrust: Int,
    val description: String,
    val isVeg: Boolean,
    val name: String,
    val getsize:List<Size>
)