package com.example.unit4eval2.views.Repository

import com.example.unit4eval2.views.model.Model
import com.example.unit4eval2.views.model.PizzaDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaRepo(val pizzaDao: PizzaDao) {


    fun addcartt(model: Model){
        CoroutineScope(Dispatchers.IO).launch {
            pizzaDao.addtocart(model)
        }
    }
    fun deletepiza(model: Model){
        CoroutineScope(Dispatchers.IO).launch {
            pizzaDao.delete(model)
        }
    }
}