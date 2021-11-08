package com.example.moviesdb

data class RespDto(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)