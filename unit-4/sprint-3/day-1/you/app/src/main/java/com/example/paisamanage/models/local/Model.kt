package com.example.paisamanage.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Moneymanage")
data class Model(@ColumnInfo(name="title") var title:String,

                 @ColumnInfo(name="date") var date:String,
                  @ColumnInfo(name="Amount") var amount:Int?

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="Id") var id:Int?=null
}