package com.example.wallpaperapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallpaperapp.Repository.MainRepo
import javax.inject.Inject

class VMfactory @Inject constructor(val repo:MainRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return mainviewModel(repo) as T
    }
}