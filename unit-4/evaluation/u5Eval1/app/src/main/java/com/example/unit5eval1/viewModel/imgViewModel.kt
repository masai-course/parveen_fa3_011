package com.example.unit5eval1.viewModel

import androidx.lifecycle.ViewModel
import com.example.unit5eval1.Repository.MainRepo

class imgViewModel:ViewModel() {

    private val repo=MainRepo()

    fun getapidata()=repo.getdata()
}