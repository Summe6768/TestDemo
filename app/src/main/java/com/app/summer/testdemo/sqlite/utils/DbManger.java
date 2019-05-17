package com.app.summer.testdemo.sqlite.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.summer.testdemo.sqlite.bean.Person;
import com.app.summer.testdemo.sqlite2.utils.MySQLiteHelper2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Summer
 * @date: 2019/5/15
 */
public class DbManger {
    private static MySqLiteHelper mySqLiteHelper;

    private static MySQLiteHelper2 mySQLiteHelper2;

    public static MySqLiteHelper getInstance(Context context) {
        if (mySqLiteHelper == null) {
            mySqLiteHelper = new MySqLiteHelper(context);
        }
        return mySqLiteHelper;
    }

    public static MySQLiteHelper2 getInstance2(Context context) {
        if (mySQLiteHelper2 == null) {
            mySQLiteHelper2 = new MySQLiteHelper2(context);
        }
        return mySQLiteHelper2;
    }


    public static void execSQL(SQLiteDatabase db, String sql) {
        if (db != null) {
            if (sql != null && !"".equals(sql)) {
                db.execSQL(sql);
            }
        }
    }


    /**
     * 查询
     *
     * @param db
     * @param sql
     * @param strings
     * @return
     */
    public static Cursor selectDataBySql(SQLiteDatabase db, String sql, String[] strings) {
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(sql, strings);
        }
        return cursor;
    }

    public static List<Person> cursorToList(Cursor cursor) {
        List<Person> list = new ArrayList<>();

        while (cursor.moveToNext()) {
            int _id = cursor.getInt(cursor.getColumnIndex(Constant._ID));
            String name = cursor.getString(cursor.getColumnIndex(Constant.NAME));
            int age = cursor.getInt(cursor.getColumnIndex(Constant.AGE));

            Person person = new Person(_id, name, age);
            list.add(person);
        }
        return list;
    }

    public static int getDataCount(SQLiteDatabase db, String tableName) {
        int count = 0;
        if (db != null) {
            Cursor cursor = db.rawQuery("select * from " + tableName + "", null);
            count = cursor.getCount();
        }
        return count;
    }

}
