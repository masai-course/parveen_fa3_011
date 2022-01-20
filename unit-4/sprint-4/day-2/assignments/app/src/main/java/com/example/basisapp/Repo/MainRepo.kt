package com.example.basisapp.Repo

import com.example.basisapp.data.Data
import com.example.basisapp.remote.ApiService
import javax.inject.Inject

class MainRepo @Inject constructor(val apiService: ApiService) {


    suspend fun getapidata():List<Data>{
        return apiService.getresult().data
    }
}