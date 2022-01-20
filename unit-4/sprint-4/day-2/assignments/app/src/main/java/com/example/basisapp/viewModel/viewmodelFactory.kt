package com.example.basisapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basisapp.Repo.MainRepo
import javax.inject.Inject

class viewmodelFactory @Inject constructor( val repo: MainRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}