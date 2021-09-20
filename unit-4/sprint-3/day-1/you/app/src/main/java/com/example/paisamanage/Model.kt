package com.example.paisamanage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Moneymanage")
data class Model(@ColumnInfo(name="title") var title:String,
                 @ColumnInfo(name="type") var type:String,
                 @ColumnInfo(name="date") var date:String,
                  @ColumnInfo(name="Amount") var amount:Int?,
                 @ColumnInfo(name="Balance") var balance:Int?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="Id") var id:Int?=null
}