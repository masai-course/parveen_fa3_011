package com.example.unit4eval2.views.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.unit4eval2.views.remote.response.PizzaModel

@Dao
interface PizzaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addtocart(pizamodel: PizzaModel)

    @Delete
    fun delete(pizamodel: PizzaModel)
}