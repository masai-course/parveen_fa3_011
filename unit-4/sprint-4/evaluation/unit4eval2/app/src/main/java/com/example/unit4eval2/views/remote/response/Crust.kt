package com.example.unit4eval2.views.remote.response

data class Crust(
    val defaultSize: Int,
    val id: Int,
    val name: String,
    val sizes: List<Size>
)