package com.example.navifragyou

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_event_detail.*


class EventDetail : Fragment(R.layout.fragment_event_detail) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        btnnext.setOnClickListener {
            val event=title.text.toString()
            val disc=disc.text.toString()
            val bundal=Bundle()
            bundal.putString("event",event)
            bundal.putString("disc",disc)
            navController.navigate(R.id.action_eventDetail_to_dateandTime,bundal)
        }
    }


}