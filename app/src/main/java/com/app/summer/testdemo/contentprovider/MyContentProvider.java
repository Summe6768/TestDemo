package com.app.summer.testdemo.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    @Override//在ContentProvider创建后被调用
    public boolean onCreate() {
        return false;
    }

    @Override//根据uri查询出selection指定的条件所匹配的全部记录，并且可以指定查询哪些列以什么方式（sortOrder）排序
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override//返回当前uri的MIME类型，如果这个uri对应的数据可能包括多条记录
    //那么这个MIME类型字符串以这个vnd.android.ier开头
    //如果该uri对应的数据只有一条，该MIME类型字符串，就是以vnd.android.curs.item/开头
    public String getType(Uri uri) {
        return null;
    }

    @Override//根据uri插入values对应的数据
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override//根据uri删除selection指定的条件它所匹配的全部记录
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override//根据uri修改selection指定的条件所匹配的全部记录
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
