package com.example.unit4eval2.views.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PizzaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addtocart(pizamodel: Model)

    @Delete
    fun delete(pizamodel: Model)
}