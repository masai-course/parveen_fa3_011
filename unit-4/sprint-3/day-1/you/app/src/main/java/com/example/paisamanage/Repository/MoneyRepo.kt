package com.example.paisamanage.Repository

import androidx.lifecycle.LiveData
import com.example.paisamanage.models.local.Model
import com.example.paisamanage.models.local.MoneyDAO
import com.example.paisamanage.remote.Network
import com.example.paisamanage.remote.response.CreatetaskRequestModel
import com.example.paisamanage.remote.response.GetTaskResponseModel
import com.example.paisamanage.remote.response.LoginResponse
import com.masai.taskmanagerapp.models.remote.APIService
import com.masai.taskmanagerapp.models.remote.Resource
import com.masai.taskmanagerapp.models.remote.ResponseHandler
import com.masai.taskmanagerapp.models.remote.requests.LoginRequestModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MoneyRepo(val moneyDAO: MoneyDAO) {

    private val api:APIService= Network.getRetrofit().create(APIService::class.java)
    private val responseHandler= ResponseHandler()

    private val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGE0YmI3OTAzMjdlN2MwNmE2MTk1ODYiLCJpYXQiOjE2MzIxMzg2ODR9.cTxpYQrTfvramIOSPih6b1hJO_x1G-V2GmaRnTYSjU0"



    suspend fun login(loginRequestModel: LoginRequestModel): Resource<LoginResponse> {
        return try {
            val response=api.login(loginRequestModel)
            responseHandler.handleSuccess(response)

        }catch(e: Exception){
            e.printStackTrace()
            responseHandler.handleException(e)
        }

    }

    fun getRemoteTask(){
        CoroutineScope(Dispatchers.IO).launch {
            val response=api.gettaskfromapi(token)
            savetoDB(response)
        }
    }

    fun createtassk(createtaskRequestModel: CreatetaskRequestModel){
        CoroutineScope(Dispatchers.IO).launch {
            val response=api.createTask(token,createtaskRequestModel)
            val newtask=Model(response.title,response.discription,0)
            moneyDAO.addtasks(newtask)
        }
    }

    private fun savetoDB(response: GetTaskResponseModel) {

        val listofTask=ArrayList<Model>()
        response.forEach {
            val NewTask=Model(it.title, it.description,0)
            listofTask.add(NewTask)
        }
        moneyDAO.addtask(listofTask)
    }

    fun addtasktoRoom(task: Model){

        CoroutineScope(Dispatchers.IO).launch {
            moneyDAO.addtasks(task)
        }

    }

    fun getallTask(): LiveData<List<Model>> {
        return moneyDAO.gettasks()

    }
    fun updatetaskss(task: Model){
        CoroutineScope(Dispatchers.IO).launch {
            moneyDAO.updatetask(task)
        }
    }
    fun deleteTask(task: Model){
        CoroutineScope(Dispatchers.IO).launch {
            moneyDAO.deletetask(task)
        }
    }
}