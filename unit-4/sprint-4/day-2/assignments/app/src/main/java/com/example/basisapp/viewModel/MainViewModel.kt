package com.example.basisapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basisapp.Repo.MainRepo
import com.example.basisapp.data.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repo: MainRepo): ViewModel() {

    private var mutablelist= MutableLiveData<List<Data>>()
    var livepagerdata: LiveData<List<Data>> =mutablelist

    fun getpageritem(){
        CoroutineScope(Dispatchers.IO).launch {
            val apiitem= repo.getapidata()
            mutablelist.postValue(apiitem)
        }
    }

}