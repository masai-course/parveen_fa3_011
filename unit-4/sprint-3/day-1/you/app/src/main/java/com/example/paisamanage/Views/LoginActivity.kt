package com.example.paisamanage.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.paisamanage.R
import com.example.paisamanage.Repository.MoneyRepo
import com.example.paisamanage.ViewModel.Viewmodel
import com.example.paisamanage.ViewModel.viewmodelFactory
import com.example.paisamanage.models.local.MoneyDAO
import com.example.paisamanage.models.local.manageRoomDatabase
import com.masai.taskmanagerapp.models.remote.Status
import com.masai.taskmanagerapp.models.remote.requests.LoginRequestModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.longToast

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




    }

    override fun onResume() {
        super.onResume()
        CoroutineScope(Dispatchers.Main).launch {
            delay(4000)

            val intent =Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
