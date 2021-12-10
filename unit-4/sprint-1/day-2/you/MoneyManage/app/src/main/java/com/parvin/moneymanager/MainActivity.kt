package com.parvin.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(),onItemClicked {

    lateinit var moneyAdapter: MoneyAdapter
    private val modelList= mutableListOf<Model>()
    val dbhandler=DatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            val intent= Intent(this,EditActivity::class.java)
            startActivityForResult(intent,0)
        }


       modelList.addAll(dbhandler.getalltasks())

        moneyAdapter= MoneyAdapter(this,modelList,this)
        Recucler.layoutManager=LinearLayoutManager(this)
        Recucler.adapter=moneyAdapter
    }

   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==0) {
            if (resultCode == 0) {
                val Title = data?.getStringExtra("title").toString()
                val amount = data?.getStringExtra("amount").toString()
                val currentDate: String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                dbhandler.insertTask("$Title","$currentDate","$amount")
                updateUI()
                Log.d("praveen", "onActivityResult")
            }
        }

    }



    override fun onEditClicked(model: Model) {
      card.visibility=View.VISIBLE

        mbtnetsave.setOnClickListener {


            val title = etedit1.text.toString()
            val amt = etedit2.text.toString()
            val currentDate: String =
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
            model.title = title
            model.Amount = amt
            model.date = currentDate

            dbhandler.editTask(model)
            card.visibility=View.GONE

            updateUI()
        }


    }

    override fun onDeleteClicked(model: Model) {

        dbhandler.deleteTask(model)
        updateUI()
    }
    fun updateUI(){
        val latesttask=dbhandler.getalltasks()
        modelList.clear()
        modelList.addAll(latesttask)
        moneyAdapter.notifyDataSetChanged()

    }

}