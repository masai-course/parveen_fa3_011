package com.example.unit5eval1.viewModel

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.unit5eval1.data.ResponseModel
import com.example.unit5eval1.data.ResponseModelItem

class paggingSourc:PagingSource<Int,ResponseModel>() {

    private val apical= Network.getApi()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseModel> {
        val pgno=params.key ?:1
        val responseModel: ResponseModel =apical.getposts(pgno)
        val datalist= responseModel

        return try {
            LoadResult.Page(
                data = datalist,
                prevKey = null,
                nextKey = if (datalist.isEmpty()) null else pgno+1
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResponseModel>): Int? {
        return state.anchorPosition
    }
}