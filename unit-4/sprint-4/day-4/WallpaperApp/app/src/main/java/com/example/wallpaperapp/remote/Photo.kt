package com.example.wallpaperapp.remote

data class Photo(
    val alt: String,
    val avg_color: String,
    val height: Int,
    val id: Int,
    val photographer: String,
    val photographer_id: Int,
    val photographer_url: String,
    val src: Src,
    val url: String,
    val width: Int
)