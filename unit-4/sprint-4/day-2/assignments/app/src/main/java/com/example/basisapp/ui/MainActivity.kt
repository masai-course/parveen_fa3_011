package com.example.basisapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.basisapp.R
import com.example.basisapp.data.Data
import com.example.basisapp.databinding.ActivityMainBinding
import com.example.basisapp.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var itemAdapter: itemAdapter
    private var pageritemlist =ArrayList<Data>()
    lateinit var activityMainBinding: ActivityMainBinding
    private val viewmodel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)




        viewmodel.getpageritem()
        viewmodel.livepagerdata.observe(this, Observer {
            pageritemlist= it as ArrayList<Data>
            setadapter()
        })

        activityMainBinding.indicator.setViewPager(activityMainBinding.viewpager)



    }

    private fun setadapter(){
        itemAdapter= itemAdapter(this,pageritemlist, activityMainBinding.viewpager)
        activityMainBinding.viewpager.adapter= itemAdapter
    }
}