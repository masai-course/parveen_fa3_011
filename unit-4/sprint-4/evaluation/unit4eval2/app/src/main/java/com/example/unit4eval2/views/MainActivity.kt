package com.example.unit4eval2.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unit4eval2.R
import com.example.unit4eval2.views.remote.ApiService
import com.example.unit4eval2.views.remote.Network
import com.example.unit4eval2.views.remote.response.PizzaModel
import com.example.unit4eval2.views.remote.response.Size
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), onAddclicked {

    private lateinit var pizamodel:List<PizzaModel>
    private lateinit var pizasize:List<Size>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       ApiCall()

    }
    fun ApiCall(){
        val apiclient= Network.getinstance().create(ApiService::class.java)
        apiclient.posts("pizzas").enqueue(object :Callback<PizzaModel>{
            override fun onResponse(call: Call<PizzaModel>, response: Response<PizzaModel>) {
                
                setrecycler()
            }

            override fun onFailure(call: Call<PizzaModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun setrecycler(){
        val pizaadapter=PizzaAdapter(pizamodel,pizasize,this)
        val layoutManager=LinearLayoutManager(this)
        Recycler.adapter=pizaadapter
        Recycler.layoutManager=layoutManager
    }



    override fun onitemClicked(position: Int, pizamodel: PizzaModel) {

    }
}