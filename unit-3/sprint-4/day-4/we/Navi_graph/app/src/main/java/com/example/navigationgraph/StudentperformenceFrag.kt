package com.example.navigationgraph

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_studentperformence.*


class StudentperformenceFrag : Fragment(R.layout.fragment_studentperformence) {

    private lateinit var name:String
    private lateinit var navController: NavController
    private var age=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getdata()
    }

    private fun getdata() {
        arguments?.run {
            name=getString("name")!!
            age=getInt("age")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        btnPreview.setOnClickListener {
            val percent=etStudentPercentage.text.toString()
            val grade=etStudentGrade.text.toString()

            val intent=Intent(context,PreviewActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("age",age)
            intent.putExtra("percent",percent)
            intent.putExtra("grade",grade)
            startActivity(intent)
        }
    }


}