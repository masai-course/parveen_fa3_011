package com.example.unit5eval1.Repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.unit5eval1.viewModel.paggingSourc

class MainRepo {

    fun getdata()=Pager(
        config = PagingConfig(pageSize = 15, maxSize = 100)
    ,pagingSourceFactory = {paggingSourc()}
    ).liveData
}