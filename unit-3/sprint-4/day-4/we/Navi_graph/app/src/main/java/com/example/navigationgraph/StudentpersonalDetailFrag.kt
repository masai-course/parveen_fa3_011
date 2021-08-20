package com.example.navigationgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_studentpersonal_detail.*


class StudentpersonalDetailFrag : Fragment(R.layout.fragment_studentpersonal_detail) {

    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        btnNext.setOnClickListener {
            val name=etStudentName.text.toString()
            val age=etStudentAge.text.toString().toInt()
            val bundle=Bundle()
            bundle.putString("name",name)
            bundle.putInt("age",age)
            navController.navigate(R.id.action_studentpersonalDetailFrag_to_studentperformenceFrag,bundle)



        }
    }




}