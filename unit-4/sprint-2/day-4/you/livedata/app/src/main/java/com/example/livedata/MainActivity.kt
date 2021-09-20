package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

     val daata=DataKaxz()
    lateinit var frag1:FragmentManager
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("praveen", "onCreate")





        daata.fraf1data().observe(this, Observer {
            val data1=it
            txtview.text=data1
        })
        daata.fraf2data().observe(this, Observer {
            val data2=it
            txtview.text=data2
        })

            frag1=supportFragmentManager
            frag1.beginTransaction().add(R.id.vfrag1,Fragment1()).commit()

            fragmentManager=supportFragmentManager
           val tra= fragmentManager.beginTransaction().add(R.id.vfrag2,Fragment2())
        tra.commit()


    }

    override fun onPause() {
        super.onPause()
        Log.d("praveen", "onPause")
    }
}