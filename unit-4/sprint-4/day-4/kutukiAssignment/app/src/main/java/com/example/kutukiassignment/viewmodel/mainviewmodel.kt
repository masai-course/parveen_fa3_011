package com.example.kutukiassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kutukiassignment.firstapi.FirstModel
import com.example.kutukiassignment.repo.repo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class mainviewmodel(val Repo:repo):ViewModel() {

    private var pagerData= MutableLiveData<List<FirstModel>>()
    var livepagerdata: LiveData<List<FirstModel>> = pagerData

    fun getdta(){
        CoroutineScope(Dispatchers.IO).launch {

            var apidata=Repo.getpageraitem()
            pagerData.postValue(apidata)
        }
    }
}