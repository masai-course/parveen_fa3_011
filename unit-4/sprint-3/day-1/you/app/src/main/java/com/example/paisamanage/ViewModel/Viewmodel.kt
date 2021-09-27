package com.example.paisamanage.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.paisamanage.Repository.MoneyRepo
import com.example.paisamanage.models.local.Model
import com.example.paisamanage.remote.response.CreatetaskRequestModel
import com.example.paisamanage.remote.response.LoginResponse
import com.masai.taskmanagerapp.models.remote.Resource
import com.masai.taskmanagerapp.models.remote.requests.LoginRequestModel
import kotlinx.coroutines.Dispatchers

class Viewmodel(val repo:MoneyRepo): ViewModel() {

    fun userlogin(loginRequestModel: LoginRequestModel): LiveData<Resource<LoginResponse>> {
        val livedata=  liveData(Dispatchers.IO) {
            val result= repo.login(loginRequestModel)
            emit(result)
        }
        return livedata
    }

    fun gettaskAPI(){
        repo.getRemoteTask()
    }
    fun createNewTask(createtaskRequestModel: CreatetaskRequestModel){
        repo.createtassk(createtaskRequestModel)
    }

    fun addtask(task: Model){
        repo.addtasktoRoom(task)
    }

    fun getTaskss(): LiveData<List<Model>> {
        return repo.getallTask()
    }
    fun updatetask(task: Model){
        repo.updatetaskss(task)
    }
    fun delete(task: Model){
        repo.deleteTask(task)
    }

}