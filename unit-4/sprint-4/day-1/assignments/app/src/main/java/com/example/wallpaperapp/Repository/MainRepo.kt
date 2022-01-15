package com.example.wallpaperapp.Repository

import android.util.Log
import com.example.wallpaperapp.api.Apiservice
import com.example.wallpaperapp.remote.Photo
import javax.inject.Inject

class MainRepo @Inject constructor(val apiservice: Apiservice) {

    suspend fun getimageitem():List<Photo>{
        Log.d("dudi", "repo resp")
        return apiservice.getResponse("563492ad6f917000010000016f292cb00158423bb135547ac1949bf9").photos
    }
}