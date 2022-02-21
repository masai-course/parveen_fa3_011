package com.example.multiplelayout.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiplelayout.R
import com.example.multiplelayout.models.chatModel
import com.example.multiplelayout.viewmodel.mainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bot_layout.*

class MainActivity : AppCompatActivity(), clicklistener {

    lateinit var  viewModel:mainViewModel
    lateinit var mainAdapter: mainAdapter
    lateinit var datalist: ArrayList<chatModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel= ViewModelProvider(this).get(mainViewModel::class.java)


        datalist= arrayListOf(chatModel("Hi custmer i am fidoo","how can i help you","tell me"))
        setadapter()


    }

    fun setadapter(){
        mainAdapter= mainAdapter(this, datalist, this)
        val linearLayoutManager= LinearLayoutManager(this)
        rvmain.adapter= mainAdapter
        rvmain.layoutManager= linearLayoutManager
    }

    override fun onCancelClick(position: Int) {
        val intent= Intent("com.chatbot")
        intent.putExtra("btnname","${btncancel.text}")
        viewModel.getcancelstatus("10","1a9eddfe5e5b2c75f6c15e739e05ab46","100002")
        setchat("item canceled","refund tomorrow", "any help" )
        mainAdapter.typeview=0
        btncancel.text="NO"


    }
    fun setchat(msg1:String,msg2:String, msg3:String){
       val chat= chatModel(msg1,msg2,msg3)
        datalist.add(chat)


    }

    override fun onSubmitClick(position: Int) {
        val intent= Intent("com.chatbot")
        intent.putExtra("btnname","${btncancel.text}")
        viewModel.getorderstatus("9","752b1a44c8f596b65b98305627481261","100011")
        viewModel.statuslivedata.observe(this, Observer {
         setchat("${it.msg1}", "${it.msg2}","any help" )
        })
        mainAdapter.typeview=0
        btnstatus.text= "YES"
    }

    override fun onDestroy() {
        datalist.clear()
        super.onDestroy()
    }
}