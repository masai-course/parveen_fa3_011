package com.example.moviestask.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviestask.Repository.mainRepo
import javax.inject.Inject

class viewmodelFactory @Inject constructor( val repo: mainRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return mainViewModel(repo) as T
    }

}