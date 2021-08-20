package com.example.navifragyou

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_dateand_time.*


class DateandTime : Fragment(R.layout.fragment_dateand_time) {

    private lateinit var navController: NavController
    private lateinit var event:String
    private lateinit var discription:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getdata()
    }

    private fun getdata() {
        arguments?.run {
             event=getString("event")!!
             discription=getString("disc")!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        btnnext2.setOnClickListener {
            val stdate=startdate.text.toString()
            val edate=Enddate.text.toString()
            val sttime=starttime.text.toString()
            val etime=endtime.text.toString()
            val bundal=Bundle()
            bundal.putString("event",event)
            bundal.putString("disc",discription)
            bundal.putString("stdate",stdate)
            bundal.putString("edate",edate)
            bundal.putString("sttime",sttime)
            bundal.putString("etime",etime)
            navController.navigate(R.id.action_dateandTime_to_priceDetail,bundal)

        }
    }


}