package com.example.moviestask.ui

import com.example.moviestask.apiresp.ComingSoon
import com.example.moviestask.apiresp.NowShowing

interface ClickListener {

    fun onPagerclick (position: Int, Comingsoon:ComingSoon)

    fun onmovieclick (position: Int, nowShowing: NowShowing)
}