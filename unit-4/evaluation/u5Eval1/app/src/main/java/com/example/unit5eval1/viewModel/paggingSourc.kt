package com.example.unit5eval1.viewModel

import android.icu.text.Transliterator
import androidx.paging.PagingSource
import com.example.unit5eval1.Network
import com.example.unit5eval1.data.ResponseModel
import retrofit2.Call

class paggingSourc:PagingSource<Int,ResponseModel>() {

    private val apical=Network.getApi()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseModel> {
        val pgno=params.key ?:1
        val responseModel: Call<ResponseModel> =apical.getposts(pgno)


    }
}