package com.csse.ticketing.com.csse.ticketing.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TokenDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ticketing.db";
    public static final String TABLE_NAME = "token";
    public static final String Col_1 = "token";

    public TokenDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                " token CHAR(6) PRIMARY KEY" +
                ")" +
                "");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public boolean insertData(String token){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_1,token);
        if(db.insert(TABLE_NAME,null,values) == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =  db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        return res;
    }

    public Integer deleteData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,null,null);
    }

}

