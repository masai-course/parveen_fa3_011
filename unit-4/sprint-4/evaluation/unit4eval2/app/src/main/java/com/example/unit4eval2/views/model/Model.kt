package com.example.unit4eval2.views.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="pizzatable")
data class Model(@ColumnInfo(name="piza")var name:String,
@ColumnInfo(name="Price")var price:Int?) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="Id") var id:Int?=null
}