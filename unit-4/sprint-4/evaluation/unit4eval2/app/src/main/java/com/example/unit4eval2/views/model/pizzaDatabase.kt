package com.example.unit4eval2.views.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.unit4eval2.views.remote.response.PizzaModel

@Database(entities = [Model::class],version = 1)
abstract class pizzaDatabase:RoomDatabase() {

    companion object{
        private var INSTANCE:RoomDatabase?=null

        fun getobject(context: Context):pizzaDatabase{
            if (INSTANCE==null){
                val builder=Room.databaseBuilder(context.applicationContext,pizzaDatabase::class.java,"pizza_DB")
                builder.fallbackToDestructiveMigration()
                INSTANCE=builder.build()
                return (INSTANCE as pizzaDatabase)
            }else{
                return (INSTANCE as pizzaDatabase)
            }
        }
    }


}