package com.app.summer.testdemo.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.summer.testdemo.R;
import com.app.summer.testdemo.enumtest.TestEnum;
import com.app.summer.testdemo.sqlite.bean.Person;
import com.app.summer.testdemo.sqlite.utils.Constant;
import com.app.summer.testdemo.sqlite.utils.DbManger;
import com.app.summer.testdemo.sqlite.utils.MySqLiteHelper;

import java.util.List;

public class SqlLiteActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOnCreateSqLite;
    private Button btnInsertData;
    private Button btnUpData;
    private Button btnDelData;
    private Button btnQueryData;
    private TextView mTvData;

    private MySqLiteHelper mySqLiteHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite);

        btnOnCreateSqLite = findViewById(R.id.btnOnCreateSqLite);
        btnInsertData = findViewById(R.id.btnInsertData);
        btnUpData = findViewById(R.id.btnUpData);
        btnDelData = findViewById(R.id.btnDelData);
        btnQueryData = findViewById(R.id.btnQueryData);
        mTvData = findViewById(R.id.tvData);

        btnOnCreateSqLite.setOnClickListener(this);
        btnInsertData.setOnClickListener(this);
        btnUpData.setOnClickListener(this);
        btnDelData.setOnClickListener(this);
        btnQueryData.setOnClickListener(this);

        mySqLiteHelper = DbManger.getInstance(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //创建数据库
            case R.id.btnOnCreateSqLite:

                break;
            case R.id.btnInsertData:
//                //插入数据
//                db = mySqLiteHelper.getWritableDatabase();
//
//                ContentValues values = new ContentValues();
//
//                values.put(Constant.NAME, "zhangjingwei");
//                values.put(Constant._ID, 1);
//                values.put(Constant.AGE, "22");
//
//                long result = db.insert(Constant.TABLE_NAME, null, values);
//
//                if (result > 0) {
//                    Toast.makeText(this, "插入数据成功", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(this, "插入数据失败", Toast.LENGTH_SHORT).show();
//                }
//
//                db.close();


                //循环插入数据
                db = mySqLiteHelper.getWritableDatabase();

                //先删除
                db.execSQL("delete from " + Constant.TABLE_NAME + "");

                //在插入
                for (int i = 0; i <= 30; i++) {
                    String sql = "insert into " + Constant.TABLE_NAME + " values(" + i + ",'张三" + i + "',20)";
                    db.execSQL(sql);
                }
                db.close();

                break;
            case R.id.btnUpData:
                //更新（修改）数据
                db = mySqLiteHelper.getWritableDatabase();

                ContentValues values2 = new ContentValues();
                values2.put(Constant.NAME, "中文");

                int count = db.update(Constant.TABLE_NAME, values2, Constant._ID + "=123", null);
                //int count = db.update(Constant.TABLE_NAME, values2, Constant._ID + "=?", new String[]{"123"});

                if (count > 0) {
                    Toast.makeText(this, "修改数据成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "修改数据失败", Toast.LENGTH_SHORT).show();
                }

                db.close();
                break;
            case R.id.btnDelData:
                //删除数据
                db = mySqLiteHelper.getWritableDatabase();

                int intDel = db.delete(Constant.TABLE_NAME, Constant._ID + "=?", new String[]{"2"});

                if (intDel > 0) {
                    Toast.makeText(this, "删除数据成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "删除数据失败", Toast.LENGTH_SHORT).show();
                }

                db.close();
                break;
            case R.id.btnQueryData:
//                //查询数据  sql语句查询
//                db = mySqLiteHelper.getWritableDatabase();
//
//                String select = "select * from " + Constant.TABLE_NAME;
//                Cursor cursor = DbManger.selectDataBySql(db, select, null);
//
//                List<Person> list = DbManger.cursorToList(cursor);
//                for (Person person : list) {
//                    Log.e("TAG", "person.....: " + person.toString());
//                }
//                db.close();


                // Api提供的方法查询
                db = mySqLiteHelper.getWritableDatabase();
                Cursor cursor = db.query(Constant.TABLE_NAME,
                        null,
                        Constant._ID + ">=?", new String[]{"0"},
                        null,
                        null,
                        null);
                List<Person> list = DbManger.cursorToList(cursor);
                for (Person person : list) {
                    Log.e("TAG", "onClick: " + person.toString());
                }
                db.close();


                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
