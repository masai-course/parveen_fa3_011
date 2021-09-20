package com.example.paisamanage

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoneyDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTasks(model: Model)

    @Query("select * from moneymanage")
    fun getTasks():LiveData<List<Model>>

    @Update
    fun updatetask(model: Model)

    @Delete
    fun deletetask(model: Model)
}