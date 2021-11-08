package com.example.u5eval2

data class ResponseModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)