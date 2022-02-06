package com.example.taskapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskapp.R
import com.example.taskapp.apidata.Data
import com.example.taskapp.databinding.ActivityMainBinding
import com.example.taskapp.viewModel.MainviewModel
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var itemAdapter: ItemAdapter
    private var itemslist = ArrayList<Data>()
    private lateinit var activityMainBinding: ActivityMainBinding

    //viewmodel obj
    private val mainviewmodel by viewModels<MainviewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        //FCM
        FirebaseMessaging.getInstance().subscribeToTopic("Notification")



        mainviewmodel.getapiresult()
        //live data observer
        mainviewmodel.livedata.observe(this, Observer {
            itemslist= it as ArrayList<Data>
            setAdapter()
            activityMainBinding.tvloading.visibility= View.GONE
        })
    }


    // set adapter and layout to recyclerview
    fun setAdapter(){
        itemAdapter= ItemAdapter(this, itemslist)
        val linearLayoutManager= LinearLayoutManager(this)
        activityMainBinding.recyclerView.apply {
            adapter= itemAdapter
            layoutManager= linearLayoutManager
        }
    }
}