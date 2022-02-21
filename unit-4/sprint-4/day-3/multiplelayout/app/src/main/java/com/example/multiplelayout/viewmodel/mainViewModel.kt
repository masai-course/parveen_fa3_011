package com.example.multiplelayout.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.multiplelayout.apiclint.CancelNetwork
import com.example.multiplelayout.models.CancelModel
import com.example.multiplelayout.models.OrderStatusModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response


class mainViewModel():ViewModel() {

    private var mutableLiveData= MutableLiveData<OrderStatusModel>()
    var statuslivedata: LiveData<OrderStatusModel> = mutableLiveData

    private var mutablecancelData= MutableLiveData<CancelModel>()
    var cancellivedata: LiveData<CancelModel> = mutablecancelData

    fun getorderstatus( accId: String, accesstoken: String, orderid: String ){

        CoroutineScope(Dispatchers.IO).launch {
            CancelNetwork.getapiservice().getstatus(accId, accesstoken, orderid).
            enqueue(object: retrofit2.Callback<OrderStatusModel>{
                override fun onResponse(
                    call: Call<OrderStatusModel>,
                    response: Response<OrderStatusModel>
                ) {
                    mutableLiveData.postValue(response.body())
                }

                override fun onFailure(call: Call<OrderStatusModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

    }

    fun getcancelstatus( accId: String, accesstoken: String, orderid: String ){

        CoroutineScope(Dispatchers.IO).launch {
            CancelNetwork.getapiservice().getcancel(accId, accesstoken, orderid)
                .enqueue(object : retrofit2.Callback<CancelModel>{
                    override fun onResponse(
                        call: Call<CancelModel>,
                        response: Response<CancelModel>
                    ) {
                        mutablecancelData.postValue(response.body())
                    }

                    override fun onFailure(call: Call<CancelModel>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })
        }

    }
}