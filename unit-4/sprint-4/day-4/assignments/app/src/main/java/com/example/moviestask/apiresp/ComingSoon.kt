package com.example.moviestask.apiresp

data class ComingSoon(
    val averageRating: Int,
    val contentRating: String,
    val duration: String,
    val id: String,
    val imdbRating: String,
    val originalTitle: String,
    val posterurl: String,
    val releaseDate: String,
    val storyline: String,
    val title: String,
    val video_url: String,
    val year: String
)