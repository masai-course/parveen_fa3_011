package com.example.paisamanage

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(),onItemClicked {

    lateinit var moneyAdapter: MoneyAdapter
    private val moneylist = mutableListOf<Model>()
    lateinit var moneyDAO: MoneyDAO
    lateinit var datadb: manageRoomDatabase
    val model = Model("", "", "", 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datadb = manageRoomDatabase.getdatabaseObject(this)
        moneyDAO = datadb.gettaskDao()

        fab.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivityForResult(intent, 0)

        }



        moneyAdapter = MoneyAdapter(this, moneylist, this)
        Recucler.layoutManager = LinearLayoutManager(this)
        Recucler.adapter = moneyAdapter

        moneyDAO.getTasks().observe(this, androidx.lifecycle.Observer {
            val task = it
            moneylist.clear()
            moneylist.addAll(task)
            moneyAdapter.notifyDataSetChanged()

        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (resultCode == 0) {
                val Title = data?.getStringExtra("title").toString()
                val type = data?.getStringExtra("type").toString()
                val amount = data?.getStringExtra("amount")?.toInt()
                if (model.type.equals("Income")) {
                    tvAmount.setTextColor(Color.GREEN)
                } else {
                    tvAmount.setTextColor(Color.RED)
                }
                val currentDate: String =
                    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                var bal = model.balance

                if (type.equals("Income")) {
                    bal = bal?.plus(amount!!)
                } else {
                    bal = bal?.minus(amount!!)
                }
                val newtask = Model(Title, type, currentDate, amount, bal)
                CoroutineScope(Dispatchers.IO).launch {
                    moneyDAO.addTasks(newtask)
                }


            }
        }
    }

    override fun onEditClicked(model: Model) {
        card.visibility = View.VISIBLE

        mbtnetsave.setOnClickListener {


            val title = etedit1.text.toString()
            val type = etedit2.text.toString()
            val amt = etedit3.text.toString()
            val currentDate: String =
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
            if (type.equals("Income")) {
                tvAmount.setTextColor(Color.GREEN)
            } else {
                tvAmount.setTextColor(Color.RED)
            }
            model.title = title
            model.type=type
            model.amount = Integer.parseInt(amt)
            var bal = model.balance

            if (type.equals("Income")) {
                bal = bal!!+ Integer.parseInt(amt)
            } else {
                bal = bal!!- Integer.parseInt(amt)
            }
            model.date = currentDate
            model.balance=bal
            CoroutineScope(Dispatchers.IO).launch {
                moneyDAO.updatetask(model)
            }
            card.visibility=View.GONE

        }
    }

        override fun onDeleteClicked(model: Model) {
            CoroutineScope(Dispatchers.IO).launch {
                moneyDAO.deletetask(model)
            }
        }

}