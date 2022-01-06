package com.example.moviestask.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviestask.Repository.mainRepo

class viewmodelFactory(val repo: mainRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return mainViewModel(repo) as T
    }

}