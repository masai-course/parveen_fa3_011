package com.example.taskapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskapp.Repository.MainRepo
import javax.inject.Inject

class viewmodelFactory @Inject constructor(val repo: MainRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainviewModel(repo) as T
    }
}