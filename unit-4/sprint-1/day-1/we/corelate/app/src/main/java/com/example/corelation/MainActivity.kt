package com.example.corelation

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.cert.CertPathBuilder.getInstance
import java.util.Calendar.getInstance
import java.util.Currency.getInstance
import kotlin.coroutines.coroutineContext
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var responseModel:ResponseModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CoroutineScope(Dispatchers.Main).launch {

            async {
                getdata()
            }
                }






    }
    suspend fun getdata() {
        val apiService: ApiService = Network.getInstance().create(ApiService::class.java)

        apiService.getUser(2)!!.enqueue(object : Callback<ResponseModel?> {
            override fun onResponse(
                call: Call<ResponseModel?>,
                response: Response<ResponseModel?>
            ) {
                val responseModel = response.body()
                val firstname: String = responseModel.getData().getFirstName()
                val lastname: String = responseModel.getData().getLastName()
                val email: String = responseModel.getData().getEmail()
                tvname.setText(firstname)
                tvlastname.setText(lastname)
                tvemail.setText(email)
                Glide.with(ivavatar).load(responseModel.getData().getAvatar()).into(ivavatar)
            }

            override fun onFailure(call: Call<ResponseModel?>, t: Throwable) {}
        })
    }




}