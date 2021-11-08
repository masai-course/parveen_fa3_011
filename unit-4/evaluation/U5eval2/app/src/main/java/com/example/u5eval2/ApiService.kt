package com.example.u5eval2

import androidx.lifecycle.LiveData
import com.example.u5eval2.data.Article
import com.example.u5eval2.data.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/everything?q=tesla&from=2021-10-08&sortBy=publishedAt&apiKey=480166648b5a441eb890253626e776cb")
     fun getposts() :LiveData<Article>
}
