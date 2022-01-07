package com.example.moviestask.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviestask.apiresp.ComingSoon
import com.example.moviestask.apiresp.NowShowing
import com.example.moviestask.Repository.mainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class mainViewModel @Inject constructor(val repo: mainRepo):ViewModel() {

  private var pagerData=MutableLiveData<List<ComingSoon>>()
    var livepagerdata:LiveData<List<ComingSoon>> = pagerData


  // posting data to mutable livedata
    fun getpageritems(){
        CoroutineScope(Dispatchers.IO).launch {

            val pagedata=repo.getpageraitem()
            pagerData.postValue(pagedata)
        }
    }

    private var moviedata=MutableLiveData<List<NowShowing>>()
    var livemovieData:LiveData<List<NowShowing>> = moviedata

    fun getMovieData(){
        CoroutineScope(Dispatchers.IO).launch {
            val moviess=repo.getmovieitem()
            moviedata.postValue(moviess)
        }

    }
}