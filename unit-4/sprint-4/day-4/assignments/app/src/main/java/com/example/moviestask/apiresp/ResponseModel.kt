package com.example.moviestask.apiresp

data class ResponseModel(
    val coming_soon: List<ComingSoon>,
    val now_showing: List<NowShowing>
)