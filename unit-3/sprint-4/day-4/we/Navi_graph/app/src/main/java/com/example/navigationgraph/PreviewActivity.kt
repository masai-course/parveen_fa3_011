package com.example.navigationgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        getDatafromIntent()
    }

    private fun getDatafromIntent() {
        intent?.run {
            tvStudentName.text=getStringExtra("name")
            tvStudentAge.text="${getIntExtra("age",0)}"
            tvStudentPercentage.text=getStringExtra("percent")
            tvStudentGrade.text=getStringExtra("grade")
        }
    }
}