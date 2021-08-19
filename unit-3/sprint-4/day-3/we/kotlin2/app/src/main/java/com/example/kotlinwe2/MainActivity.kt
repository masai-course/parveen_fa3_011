package com.example.kotlinwe2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchfrag()
    }

    private fun launchfrag(){
        val fragmentmanager=supportFragmentManager
        val fragmenttransation=fragmentmanager.beginTransaction()
         fragmenttransation.add(R.id.container,UserDetailFragment(),"userDetailFragment").commit()

    }
}