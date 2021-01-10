package com.example.thanhlong;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(username text primary key,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");

    }

    public boolean insert(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put("username", username);
        contentValue.put("password", password);
        long ins = db.insert("user", null, contentValue);
        if (ins == -1) return false;
        else return true;
    }

    public boolean ckUserName(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select* from user where username=?", new String[]{username});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    ;

    public boolean ckLUserName(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select* from user where username=?", new String[]{username});
        if (cursor.getCount() > 1) return false;
        else return true;
    }

    ;

    public boolean ckLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select* from user where username=? AND password=?", new String[]{username, password});

        if (cursor.getCount() != 1) return false;
        else return true;
    }

    ;

    public String ckusername(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select* from user where username=?", new String[]{username});
        cursor.moveToFirst();
        String userName = cursor.getString(cursor.getColumnIndex("username"));
        return userName;
    }

    ;

}
