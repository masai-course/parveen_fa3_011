package com.example.paisamanage.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.paisamanage.Repository.MoneyRepo

class  viewmodelFactory(val repo: MoneyRepo): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return Viewmodel(repo) as T
    }
}