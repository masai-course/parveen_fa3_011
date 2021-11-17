package com.example.paisamanage.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paisamanage.R
import kotlinx.android.synthetic.main.activity_add_item.*

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        btnsave.setOnClickListener {
            val intent = Intent()
            intent.putExtra("title", ettitle.text.toString())
            intent.putExtra("amount", etAmount.text.toString())
            setResult(0, intent)
            finish()

        }


    }
}