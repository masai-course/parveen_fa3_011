package com.example.paisamanage.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paisamanage.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.longToast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnsignup.setOnClickListener {
            longToast("Successful")
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}