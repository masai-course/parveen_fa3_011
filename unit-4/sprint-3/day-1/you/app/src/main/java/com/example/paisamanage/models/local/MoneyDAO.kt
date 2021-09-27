package com.example.paisamanage.models.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoneyDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addtasks(model: Model)

    @Insert(onConflict =OnConflictStrategy.REPLACE )
    fun addtask(task:ArrayList<Model>)

    @Query("select * from moneymanage")
    fun gettasks():LiveData<List<Model>>

    @Update
    fun updatetask(model: Model)

    @Delete
    fun deletetask(model: Model)

    @Query("delete from moneymanage")
    fun deleteall()
}