package com.example.navifragyou

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_price_detail.*


class PriceDetail : Fragment(R.layout.fragment_price_detail) {

    private lateinit var navController: NavController
    private lateinit var event:String
    private lateinit var discription:String
    private lateinit var stdate:String
    private lateinit var edate:String
    private lateinit var sttime:String
    private lateinit var etime:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataa()
    }

    private fun getDataa() {
        arguments?.run {
             event=getString("event")!!
             discription=getString("disc")!!
             stdate=getString("stdate")!!
             edate=getString("edate")!!
             sttime=getString("sttime")!!
             etime=getString("etime")!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        btnpreview.setOnClickListener {
            val price=price.text.toString().toInt()
            val intent=Intent(context,PreviewActivity::class.java)
            intent.putExtra("event",event)
            intent.putExtra("discription",discription)
            intent.putExtra("stdate",stdate)
            intent.putExtra("edate",edate)
            intent.putExtra("sttime",sttime)
            intent.putExtra("etime",etime)
            intent.putExtra("price",price)
            startActivity(intent)
        }
    }

}