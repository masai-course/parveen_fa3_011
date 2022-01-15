package com.example.wallpaperapp.ui

import android.icu.text.Transliterator
import com.example.wallpaperapp.remote.Photo

interface ClickListener {

    fun onimageclick (position:Int, photo: Photo)
}