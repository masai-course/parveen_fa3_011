package com.example.unit4eval1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataHandler(val context:Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {

   companion object{
       val DB_NAME="itemdb"
       val DB_VERSION=1
       val TABLE_NAME="itemTable"
       val ID="id"
       val TITLE="title"
       val DESC="desc"
       val AMOUNT="amount"
   }

    override fun onCreate(db: SQLiteDatabase?) {
        val TABLE_QUERY="CREATE_TABLE "+
                "$TABLE_NAME("+
                "$ID INTEGER PRIMARY KEY,"+
                "$TITLE TEXT,"+
                "$DESC TEXT,"+
                "$AMOUNT TEXT)"

        db?.execSQL(TABLE_QUERY)
    }
    fun insertTask(title:String, desc:String,amount:String){
        val db=writableDatabase
        val values=ContentValues()
        values.put(TITLE,title)
        values.put(DESC,desc)
        values.put(AMOUNT,amount)

       val allvalue= db.insert(TABLE_NAME,null,values)

        if(allvalue.toInt()==-1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()

        }
    }
    fun findtask():MutableList<Model>{
        val itemlist= mutableListOf<Model>()
        val db=readableDatabase
        val quary="select * from $TABLE_NAME"

        val cursor=db?.rawQuery(quary,null)
        if(cursor?.count!! >0){
            if(cursor.moveToFirst()){
                do {
                    val id=cursor.getInt(cursor.getColumnIndex(ID))
                    val title=cursor.getString(cursor.getColumnIndex(TITLE))
                    val disc=cursor.getString(cursor.getColumnIndex(DESC))
                    val amount=cursor.getString(cursor.getColumnIndex(AMOUNT))

                    val model=Model()
                    model.id=id
                    model.title=title
                    model.desc=disc
                    model.amount=amount
                    itemlist.add(model)
                }while (cursor.moveToNext())
            }
        }
        return itemlist
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}