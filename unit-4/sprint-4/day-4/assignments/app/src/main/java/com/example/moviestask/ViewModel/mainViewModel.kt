package com.example.moviestask.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviestask.apiresp.ComingSoon
import com.example.moviestask.apiresp.NowShowing
import com.example.moviestask.Repository.mainRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class mainViewModel(val repo: mainRepo):ViewModel() {

  private var pagerData=MutableLiveData<List<ComingSoon>>()
    var livepagerdata:LiveData<List<ComingSoon>> = pagerData

    private var moviedata=MutableLiveData<List<NowShowing>>()
    var livemovieData:LiveData<List<NowShowing>> = moviedata

    fun getpageritems(){
        CoroutineScope(Dispatchers.IO).launch {
            val pagedata=repo.getpageraitem()
            pagerData.postValue(pagedata)
        }
    }

    fun getMovieData(){
        CoroutineScope(Dispatchers.IO).launch {
            val moviess=repo.getmovieitem()
            moviedata.postValue(moviess)
        }

    }
}