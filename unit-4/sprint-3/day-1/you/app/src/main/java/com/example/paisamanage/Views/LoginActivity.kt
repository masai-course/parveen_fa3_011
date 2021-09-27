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
import org.jetbrains.anko.longToast

class LoginActivity : AppCompatActivity() {

    lateinit var viewmodel: Viewmodel
    lateinit var roomdb: manageRoomDatabase
    lateinit var taskdao: MoneyDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        roomdb= manageRoomDatabase.getdatabaseObject(this)
        taskdao=roomdb.gettaskDao()
        val repo= MoneyRepo(taskdao)

        val viewmodelfactory= viewmodelFactory(repo)
        viewmodel= ViewModelProviders.of(this,viewmodelfactory).get(Viewmodel::class.java)
        val user=etusername.text.toString()
        val password=etpassword.text.toString()
        btnLogin.setOnClickListener {


            val loginRequestModel= LoginRequestModel(
                "$user",
                "$password")

            viewmodel.userlogin(loginRequestModel).observe(this, Observer {
                val response=it
                when (response.status){
                    Status.SUCCESS ->{
                        val name=response.data?.user?.name!!
                        val email=response.data?.user?.email!!

                        val intent= Intent(this,MainActivity::class.java)
                        startActivity(intent)

                    }
                    Status.ERROR ->{
                        val error=response.message!!

                        longToast("error=$error")
                    }

                }
            })
        }

        tvsign.setOnClickListener {
            val int= Intent(this, SignUpActivity::class.java)
            startActivity(int)
        }
    }
}
