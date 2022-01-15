package com.example.wallpaperapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallpaperapp.Repository.MainRepo
import com.example.wallpaperapp.remote.Photo
import com.example.wallpaperapp.remote.Src
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class mainviewModel @Inject constructor(private val repo:MainRepo):ViewModel() {

    private var imageList = MutableLiveData<List<Photo>>()
    var liveimagedata:LiveData<List<Photo>> = imageList


    //posting values to mutable livedata
    fun getimages(){
        CoroutineScope(Dispatchers.IO).launch {
            val apidata=repo.getimageitem()
            imageList.postValue(apidata)

        }
    }

}