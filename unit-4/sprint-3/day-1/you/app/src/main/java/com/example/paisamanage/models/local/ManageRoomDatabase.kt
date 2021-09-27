package com.example.paisamanage.models.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Model::class],version = 1)
abstract class manageRoomDatabase:RoomDatabase() {


    abstract fun gettaskDao(): MoneyDAO

    companion object{
        private var INSTANCE:RoomDatabase?=null

        fun getdatabaseObject(context: Context): manageRoomDatabase {
            if(INSTANCE ==null){
                val builder= Room.databaseBuilder(
                    context.applicationContext, manageRoomDatabase::class.java,
                    "money_db"
                )
                builder.fallbackToDestructiveMigration()

                INSTANCE =builder.build()
                return (INSTANCE as manageRoomDatabase?)!!
            }else{
                return (INSTANCE as manageRoomDatabase?)!!
            }
        }
    }
}