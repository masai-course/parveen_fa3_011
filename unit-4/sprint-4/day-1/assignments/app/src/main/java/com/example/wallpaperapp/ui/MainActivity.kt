package com.example.wallpaperapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperapp.R
import com.example.wallpaperapp.api.Network
import com.example.wallpaperapp.databinding.ActivityMainBinding
import com.example.wallpaperapp.remote.Photo
import com.example.wallpaperapp.viewModel.mainviewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ClickListener {

    lateinit var imageAdapter: ImageAdapter
    private var imageList= ArrayList<Photo>()
    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewmodel by viewModels<mainviewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)



        viewmodel.getimages()
        //livedata observer
        viewmodel.liveimagedata.observe(this, Observer {
            imageList= it as ArrayList<Photo>
            setrecycler()
        })


    }
    // set adapter and layoutmanager to recycler view
    fun setrecycler(){
        imageAdapter= ImageAdapter(this,imageList, this)
        var gridLayoutManager = GridLayoutManager(this,2)

            activityMainBinding.recuclerview.apply {
                adapter=imageAdapter
                layoutManager=gridLayoutManager
            }


    }

    override fun onimageclick(position: Int, photo: Photo) {
        val intent =Intent(this, setwallpaperActivity::class.java)
        intent.putExtra("Image", photo.src.medium)
        startActivity(intent)

    }
}