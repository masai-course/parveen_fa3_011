package com.example.unit4eval2.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unit4eval2.R

class MainActivity : AppCompatActivity(), onAddclicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onitemClicked(position: Int, pizamodel: PizzaModel) {
        TODO("Not yet implemented")
    }
}