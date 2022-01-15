package com.example.wallpaperapp.ui

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.ActivitySetwallpaperBinding
import kotlinx.coroutines.*
import java.io.IOException
import java.net.URL

class setwallpaperActivity : AppCompatActivity() {

    private lateinit var activitySetwallpaperBinding: ActivitySetwallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySetwallpaperBinding= DataBindingUtil.setContentView(this,R.layout.activity_setwallpaper)

        val resulturl=intent.getStringExtra("Image")
        Glide.with(this).load(resulturl).into(activitySetwallpaperBinding.ivsetimage)

        val ImgUrl=URL(resulturl)
        activitySetwallpaperBinding.btnsetwallpaper.setOnClickListener {
            val result: Deferred<Bitmap?> = GlobalScope.async {
                ImgUrl.toBitmap()
            }

            GlobalScope.launch(Dispatchers.IO) {
                val wallpaperManager = WallpaperManager.getInstance(applicationContext)
                wallpaperManager.setBitmap(result.await())
            }

            Toast.makeText(this,"Successful",Toast.LENGTH_SHORT).show()
        }

    }
    fun URL.toBitmap(): Bitmap? {
        return try {
            BitmapFactory.decodeStream(openStream())
        } catch (e: IOException) {
            null
        }


    }
}