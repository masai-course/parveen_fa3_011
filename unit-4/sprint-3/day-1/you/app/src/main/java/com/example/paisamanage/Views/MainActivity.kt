package com.example.paisamanage.Views

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paisamanage.R
import com.example.paisamanage.Repository.MoneyRepo
import com.example.paisamanage.ViewModel.Viewmodel
import com.example.paisamanage.ViewModel.viewmodelFactory
import com.example.paisamanage.models.local.Model
import com.example.paisamanage.models.local.MoneyDAO
import com.example.paisamanage.models.local.manageRoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), onItemClicked {

    lateinit var moneyAdapter: MoneyAdapter
    private val moneylist = mutableListOf<Model>()
    lateinit var moneyDAO: MoneyDAO
    lateinit var datadb: manageRoomDatabase
    val model = Model("", "", 0)
    lateinit var viewmodel: ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datadb = manageRoomDatabase.getdatabaseObject(this)
        moneyDAO = datadb.gettaskDao()

        val repo= MoneyRepo(moneyDAO)
        val viewmodelfactory=viewmodelFactory(repo)
        viewmodel= ViewModelProviders.of(this,viewmodelfactory).get(Viewmodel::class.java)

        fab.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivityForResult(intent, 0)

        }



        moneyAdapter = MoneyAdapter(this, moneylist, this)
        Recucler.layoutManager = LinearLayoutManager(this)
        Recucler.adapter = moneyAdapter

        moneyDAO.gettasks().observe(this, androidx.lifecycle.Observer {
            val task = it
            moneylist.clear()
            moneylist.addAll(task)
            moneyAdapter.notifyDataSetChanged()

        })
        (viewmodel as Viewmodel).gettaskAPI()



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (resultCode == 0) {
                val Title = data?.getStringExtra("title").toString()
                val amount = data?.getStringExtra("amount")?.toInt()

                val currentDate: String =
                    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())



                val newtask = Model(Title, currentDate, amount)
                CoroutineScope(Dispatchers.IO).launch {
                    moneyDAO.addtasks(newtask)
                }


            }
        }
    }

    override fun onEditClicked(model: Model) {
        card.visibility = View.VISIBLE

        mbtnetsave.setOnClickListener {


            val title = etedit1.text.toString()

            val amt = etedit3.text.toString()
            val currentDate: String =
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            model.title = title

            model.amount = Integer.parseInt(amt)



            model.date = currentDate

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