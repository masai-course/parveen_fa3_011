package com.example.livedata

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_2.*

class Fragment2 : Fragment(R.layout.fragment_2) {

    val incrdata=DataKaxz()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn2.setOnClickListener {
            incrdata.frag2get()

        }
    }


}