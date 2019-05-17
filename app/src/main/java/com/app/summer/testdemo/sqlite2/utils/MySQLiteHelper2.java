package com.app.summer.testdemo.sqlite2.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author: Summer
 * @date: 2019/5/16
 */
public class MySQLiteHelper2 extends SQLiteOpenHelper {

    public MySQLiteHelper2(Context context) {
        super(context, Constant2.DATABASE_NAME, null, Constant2.DATABASE_VERSION);
    }

    public MySQLiteHelper2(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("TAG", "onCreate: ");
        db.execSQL("create table " + Constant2.TABLE_NAME + "(" + Constant2._ID + " int," + Constant2.TEXT + " string)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.e("TAG", "onOpen: ");
    }
}
