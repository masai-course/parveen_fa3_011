package com.example.pickgrey

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.pickgrey.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var count=0
    private var list= listOf<Int>(0,1,2,3)
    private var num=0
     private var boo:Boolean =true
     lateinit var  myhandler: Handler
     lateinit var myrunable: Runnable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        startgame()
        myhandler = Handler()
        myrunable= Runnable {
            kotlin.run {
                boo=false
                activityMainBinding.cvcard.visibility = View.VISIBLE
                activityMainBinding.tvtotalscore.text = "TOTAL SCORE: $count"
                count=0
            }
        }
        starthandler()

        activityMainBinding.view0.setOnClickListener {
            if (num==0){
                count = count+1
                activityMainBinding.tvscorenet.text= "$count"
            }else{
                boo=false
                activityMainBinding.cvcard.visibility = View.VISIBLE
                activityMainBinding.tvtotalscore.text = "TOTAL SCORE: $count"
                count=0
            }
        }
        activityMainBinding.view1.setOnClickListener {
            if (num==1){
                count = count+1
                activityMainBinding.tvscorenet.text= "$count"
            }else{
                boo=false
                activityMainBinding.cvcard.visibility = View.VISIBLE
                activityMainBinding.tvtotalscore.text = "TOTAL SCORE: $count"
                count=0
            }
        }
        activityMainBinding.view2.setOnClickListener {
            if (num==2){
                count = count+1
                activityMainBinding.tvscorenet.text= "$count"
            }else{
                boo=false
                activityMainBinding.cvcard.visibility = View.VISIBLE
                activityMainBinding.tvtotalscore.text = "TOTAL SCORE: $count"
                count=0
            }
        }
        activityMainBinding.view3.setOnClickListener {
            if (num==3){
                count = count+1
                activityMainBinding.tvscorenet.text= "$count"
            }else{
                boo=false
                activityMainBinding.cvcard.visibility = View.VISIBLE
                activityMainBinding.tvtotalscore.text = "TOTAL SCORE: $count"
                count=0
            }
        }

        activityMainBinding.btnrestart.setOnClickListener {
           boo=true
            activityMainBinding.cvcard.visibility=View.GONE
            activityMainBinding.tvscorenet.text= "0"
            startgame()
        }




    }
    suspend fun getrandomnum(){

       var random= list.random()
        num=random
        if (random==0){
            activityMainBinding.view0.setBackgroundColor(Color.parseColor("#808080"))
            delay(1000)
            activityMainBinding.view0.setBackgroundColor(Color.parseColor("#fb2112"))
        }else if (random==1){
            activityMainBinding.view1.setBackgroundColor(Color.parseColor("#808080"))
            delay(1000)
            activityMainBinding.view1.setBackgroundColor(Color.parseColor("#3235ac"))
        }else if (random==2){
            activityMainBinding.view2.setBackgroundColor(Color.parseColor("#808080"))
            delay(1000)
            activityMainBinding.view2.setBackgroundColor(Color.parseColor("#f6f93b"))
        }else if (random==3){
            activityMainBinding.view3.setBackgroundColor(Color.parseColor("#808080"))
            delay(1000)
            activityMainBinding.view3.setBackgroundColor(Color.parseColor("#02991b"))
        }


    }


    fun startgame(){
        CoroutineScope(Dispatchers.Main).launch {
            while (boo){
                getrandomnum()
            }
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        stophandler()
        starthandler()
    }
    fun starthandler(){
        myhandler.postDelayed(myrunable, 1000)
    }
    fun stophandler(){
        myhandler.removeCallbacks(myrunable)
    }
}