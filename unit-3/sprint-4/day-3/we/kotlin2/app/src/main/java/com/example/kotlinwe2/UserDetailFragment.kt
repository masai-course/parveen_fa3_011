package com.example.kotlinwe2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_user_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    private lateinit var responseDTO: ResponseDTO
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnfetch.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiClient=Network.getInstance().create(ApiClient::class.java)
        apiClient.getposts(2).enqueue(object :Callback<ResponseDTO>{
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                response.body()?.run {
                    responseDTO=this

                    responseDTO.data?.apply {
                        tvname.text=first_name
                        tvlastname.text=last_name
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}