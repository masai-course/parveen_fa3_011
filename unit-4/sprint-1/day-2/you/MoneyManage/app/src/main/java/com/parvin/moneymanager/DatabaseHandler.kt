package com.parvin.moneymanager

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHandler(val context: Context): SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {

    companion object{
        val DB_NAME="Moneydb"
        val DB_VERSION=1
        val TABLE_NAME="MoneyManage"
        val ID="id"
        val TITLE="title"
        val DATE="date"
        val AMOUNT="amount"
    }
   override fun onCreate(db: SQLiteDatabase?) {
        val TABLE_QUERY="CREATE TABLE "+
                "$TABLE_NAME("+
                "$ID INTEGER PRIMARY KEY,"+
                "$TITLE TEXT,"+
                "$DATE TEXT,"+
                "$AMOUNT TEXT)"

        db?.execSQL(TABLE_QUERY)
    }

    fun insertTask(title:String, date:String,amount:String) {
        val db:SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(TITLE, title)
        values.put(DATE, date)
        values.put(AMOUNT,amount)

        val idvalue= db.insert(TABLE_NAME, null, values)

        if (idvalue.toInt() == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }
    fun getalltasks():MutableList<Model>{
        val tasklist= mutableListOf<Model>()

        val db:SQLiteDatabase=readableDatabase
        val query="select * from $TABLE_NAME"

        val cursor=db?.rawQuery(query,null)
        if(cursor.count>0) {
            if (cursor.moveToFirst()) {


                do {
                    val id = cursor.getInt(cursor.getColumnIndex(ID))
                    val title = cursor.getString(cursor.getColumnIndex(TITLE))
                    val date = cursor.getString(cursor.getColumnIndex(DATE))
                    val amount = cursor.getString(cursor.getColumnIndex(AMOUNT))

                    val task = Model()
                    task.id = id
                    task.title = title
                    task.date = date
                    task.Amount = amount

                    tasklist.add(task)

                } while (cursor.moveToNext())
            }
        }
        return tasklist
    }
    fun editTask(model:Model){
        val db=writableDatabase
        val values= ContentValues()
        values.put(TITLE,model.title)
        values.put(DATE,model.date)
        values.put(AMOUNT,model.Amount)

        val result=db.update(TABLE_NAME,values, "id=${model.id}",null)

        if(result==1){
            Toast.makeText(context,"Success update",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(context,"Failed to update",Toast.LENGTH_SHORT).show()

        }
    }
    fun deleteTask(model: Model){
        val db=writableDatabase
        val result= db.delete(TABLE_NAME,"id=${model.id}",null)

        if(result==1){
            Toast.makeText(context,"Success Delete",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(context,"Failed to delete",Toast.LENGTH_SHORT).show()

        }
    }




    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}