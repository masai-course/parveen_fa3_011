package com.example.moviestask.Repository

import com.example.moviestask.apiresp.ComingSoon
import com.example.moviestask.apiresp.NowShowing
import com.example.moviestask.remote.network

class mainRepo {

    suspend fun getpageraitem():List<ComingSoon>{
        return network.getapiservice().getresult().coming_soon
    }

    suspend fun getmovieitem():List<NowShowing>{
            return network.getapiservice().getresult().now_showing
    }
}