package com.example.moviestask.Repository

import com.example.moviestask.apiresp.ComingSoon
import com.example.moviestask.apiresp.NowShowing
import com.example.moviestask.remote.ApiService
import com.example.moviestask.remote.network
import javax.inject.Inject

class mainRepo @Inject constructor(val apiService: ApiService) {


    // fetching Coming soon in list
    suspend fun getpageraitem():List<ComingSoon>{
        return apiService.getresult().coming_soon
    }


    // fetching Now showing in list

    suspend fun getmovieitem():List<NowShowing>{
            return apiService.getresult().now_showing
    }
}