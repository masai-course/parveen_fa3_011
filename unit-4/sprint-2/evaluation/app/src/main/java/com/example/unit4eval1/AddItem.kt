package com.example.unit4eval1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_add_item.*

class AddItem : AppCompatActivity() {


    val dbhandler=DataHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_item)

        val Title=ettitle.text.toString()
        val Disc=etdisc.text.toString()
        val Amount=etprice.text.toString()

        btnsave.setOnClickListener {
            dbhandler.insertTask("$Title","$Disc","$Amount")

        }

    }
}