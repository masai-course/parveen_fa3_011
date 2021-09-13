package com.example.unit4eval1

import android.content.Intent
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager=supportFragmentManager

       btnadd.setOnClickListener {
          val intent=Intent(this,AddItem::class.java)
           startActivity(intent)
       }
        btnsearch.setOnClickListener {
         val intent=Intent(this,SearchItem::class.java)
            startActivity(intent)
        }
    }

}

