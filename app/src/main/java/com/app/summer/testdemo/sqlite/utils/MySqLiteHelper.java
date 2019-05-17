package com.app.summer.testdemo.sqlite.utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author: Summer
 * @date: 2019/5/15
 */
public class MySqLiteHelper extends SQLiteOpenHelper {


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("TAG", "onCreate: ");
        String sql = "create table " + Constant.TABLE_NAME + "(" + Constant._ID + " Integer primary key, "
                +Constant.NAME +" varchar(10), " +Constant.AGE +" Integer)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("TAG", "onUpgrade: ");
    }

    public MySqLiteHelper(Context context) {
        super(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERSION);
    }


    public MySqLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySqLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public MySqLiteHelper(Context context, String name, int version, SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.e("TAG", "onOpen: ");
    }
}
