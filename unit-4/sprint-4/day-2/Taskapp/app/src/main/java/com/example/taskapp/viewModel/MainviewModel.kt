package com.example.taskapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskapp.Repository.MainRepo
import com.example.taskapp.apidata.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainviewModel @Inject constructor(val mainRepo: MainRepo): ViewModel() {

    private var mutableitemData= MutableLiveData<List<Data>>()
    var livedata: LiveData<List<Data>> =mutableitemData


//post data to mutablelivedata
    fun getapiresult(){
        CoroutineScope(Dispatchers.IO).launch {
            val apiresp= mainRepo.getapidata()
            mutableitemData.postValue(apiresp)
        }
    }
}