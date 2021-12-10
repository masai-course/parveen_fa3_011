package com.parvin.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        btnsave.setOnClickListener {
            val intent = Intent()
            intent.putExtra("title", ettitle.text.toString())
            intent.putExtra("amount", etAmount.text.toString())
            setResult(0, intent)
            finish()

        }
    }
}