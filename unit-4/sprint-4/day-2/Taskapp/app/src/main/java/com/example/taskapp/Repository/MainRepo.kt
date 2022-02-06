package com.example.taskapp.Repository

import com.example.taskapp.apidata.Data
import com.example.taskapp.remote.apiService
import javax.inject.Inject

class MainRepo @Inject constructor(val apiService: apiService) {


    //get list of data from api
    suspend fun getapidata():List<Data>{
        return apiService.getResult().data
    }
}