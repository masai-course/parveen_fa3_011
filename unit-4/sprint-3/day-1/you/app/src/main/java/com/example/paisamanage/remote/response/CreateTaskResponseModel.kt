package com.example.paisamanage.remote.response

data class CreateTaskResponseModel(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val discription: String,
    val owner: String,
    val status: Int,
    val title: String,
    val updateAt: String
)
