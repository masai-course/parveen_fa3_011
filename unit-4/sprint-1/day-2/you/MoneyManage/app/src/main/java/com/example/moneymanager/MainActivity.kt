package com.example.moneymanager

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
            dbhandler.insertTask("Title","Date","Amount")
            updateUI()

        }
       /* if(intent!=null&& intent.extras!=null) {
            val intent = intent
            val Title = intent.getStringExtra("title").toString()
            val amount = intent.getStringExtra("amount").toString()
            val currentDate: String =
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
            val model = Model()
            model.title = Title
            model.Amount = amount
            model.date = currentDate

            dbhandler.editTask(model)
            updateUI()*/

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
                val model=Model()
                model.title=Title
                model.Amount=amount
                model.date=currentDate

                dbhandler.editTask(model)
                updateUI()
                Log.d("praveen", "onActivityResult")
            }
        }

    }



    override fun onEditClicked(model: Model) {
       val intent= Intent(this,EditActivity::class.java)
        startActivityForResult(intent,0)

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