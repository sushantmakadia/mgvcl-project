package com.example.sushant.parden.sqlite;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="MGVCL.db";
    public static final String TABLE_NAME="MGVCL_DATA";
    public static final String COL_1="USER_ID";
    public static final String COL_2="FORM_NAME";
    public static final String COL_3="FORM_DATA";
    public static final String COL_4="check_data";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,FORM_NAME TEXT,FORM_DATA VARCHAR,check_data INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String formName,String formDATA,Integer check){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,formName);
        contentValues.put(COL_3,formDATA);
        contentValues.put(COL_4,check);
        long result=db.insert("MGVCL_DATA",null,contentValues);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM MGVCL_DATA WHERE check_data = '0'", null);
    }

    public void setData(String user_id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("update MGVCL_DATA set check_data = '1' WHERE USER_ID ="+user_id);
    }
//    public Boolean updateData(String id,String name,String surname,String marks){
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(COL_1,id);
//        contentValues.put(COL_2,name);
//        contentValues.put(COL_3,surname);
//        contentValues.put(COL_4,marks);
//        db.update(TABLE_NAME,contentValues,"id= ?",new String[] { id });
//        return true;
//    }
    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.delete(TABLE_NAME,"ID = ?",new String []{id});
    }
}

