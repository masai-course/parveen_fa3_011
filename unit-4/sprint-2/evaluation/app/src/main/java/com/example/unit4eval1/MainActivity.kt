package com.example.unit4eval1

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
additemfrag(AddItemFragment())

       }
        btnsearch.setOnClickListener {

        }
    }
    fun additemfrag(addItemFragment: AddItemFragment){
        val transaction:FragmentTransaction=fragmentManager.beginTransaction()
        val fragmentadd=AddItemFragment
        transaction.add(R.id.linear,fragmentadd,"frag")
        transaction.commit()

    }
    fun addsearchfrag(searchitemFragment: SearchitemFragment){
        var transaction=fragmentManager.beginTransaction()
        val fragmentsearch=SearchitemFragment
           transaction.replace()

    }
}