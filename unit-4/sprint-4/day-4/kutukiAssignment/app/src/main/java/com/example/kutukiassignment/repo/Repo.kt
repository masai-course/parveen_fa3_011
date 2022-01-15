package com.example.kutukiassignment.repo

import com.example.kutukiassignment.apii.ApiService
import com.example.kutukiassignment.firstapi.FirstModel
import com.example.kutukiassignment.firstapi.VideoCategories

class repo(val apiService: ApiService) {

    suspend fun getpageraitem():FirstModel{
        return apiService.getresult()
    }
}