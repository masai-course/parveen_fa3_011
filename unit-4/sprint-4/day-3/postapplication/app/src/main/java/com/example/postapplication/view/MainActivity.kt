package com.example.postapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.postapplication.R
import com.example.postapplication.respapi.OrderStatu
import com.example.postapplication.respapi.ResModel
import com.example.postapplication.service.Network
import com.example.postapplication.service.apiservice
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val apiclient= Network.getretrofit().create(apiservice::class.java)

        val orderStatu= OrderStatu("gurugram", "hi", "this ","is","my",
        "post","","","","","",
        "","","","","","","","","",
        "","","","","","","","",
        "","","","","")



        apiclient.getdata("752b1a44c8f596b65b98305627481261",9,100011).enqueue(object : Callback<ResModel>{
            override fun onResponse(call: Call<ResModel>, response: Response<ResModel>) {
                response.body()?.run {
                    tvadd.text= "Done"
                }
            }

            override fun onFailure(call: Call<ResModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_LONG).show()
                Log.d("dudi", "${t.toString()}")

            }

        })
    }
}