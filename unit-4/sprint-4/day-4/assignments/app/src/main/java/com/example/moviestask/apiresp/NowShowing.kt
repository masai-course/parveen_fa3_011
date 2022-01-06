package com.example.moviestask.apiresp

data class NowShowing(
    val actors: List<String>,
    val averageRating: Int,
    val contentRating: String,
    val duration: String,
    val id: String,
    val imdbRating: Any,
    val originalTitle: String,
    val posterurl: String,
    val releaseDate: String,
    val storyline: String,
    val title: String,
    val video_url: String,
    val year: String
)