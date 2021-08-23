package com.example.scopefunyou

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), itemclickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchfrag()
    }
    private fun launchfrag(){
        val fragmentmanager=supportFragmentManager
        val fragmenttransation=fragmentmanager.beginTransaction()
        fragmenttransation.add(R.id.container,DetailFrag(),"DetailFragment").commit()

    }

    override fun onitemClicked(position: Int, datalist: Data) {
        super.onitemClicked(position, datalist)
        val alertDialog: AlertDialog = AlertDialog.Builder(this)
            .setTitle("Hey this is the Data")
            .setMessage(
                datalist.first_name+ "\n"
                        + datalist.email
            ).setPositiveButton("Ok",
                DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() }).show()

    }
}